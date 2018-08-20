package com.qaprosoft.shortesttrip.searchalgorithm;

import java.util.*;
import com.qaprosoft.shortesttrip.models.Road;
import com.qaprosoft.shortesttrip.models.Station;

public class Dijkstra {
	
	private Graph graph;
	private Long initialStationId;
	private Long destinationId;
	private HashMap<Long, Long> predecessors;
	private HashMap<Long, Double> distances;
	private PriorityQueue<Station> availableStations;
	private HashSet<Station> visitedStations;

	public Dijkstra(Graph graph, Long initialStationId) {
		this.graph = graph;
		Set<Long> stationKeys = this.graph.stationKeys();
		if (!stationKeys.contains(initialStationId)) {
			throw new IllegalArgumentException("The graph must contain the initial vertex.");
		}
		this.initialStationId = initialStationId;
		this.predecessors = new HashMap<Long, Long>();
		this.distances = new HashMap<Long, Double>();
		this.availableStations = new PriorityQueue<Station>(stationKeys.size(), new Comparator<Station>() {
			public int compare(Station one, Station two) {
				Double distanceOne = Dijkstra.this.distances.get(one.getId());
				Double distanceTwo = Dijkstra.this.distances.get(two.getId());
				if (distanceOne>distanceTwo) return 1;
				if (distanceOne<distanceTwo) return -1;
				return 0;
			}
		});
		this.visitedStations = new HashSet<Station>();
		// for each Vertex in the graph
		// assume it has distance infinity denoted by Integer.MAX_VALUE
		for (Long key : stationKeys) {
			this.predecessors.put(key, null);
			this.distances.put(key, Double.MAX_VALUE);
		}
		// the distance from the initial vertex to itself is 0
		this.distances.put(initialStationId, (double) 0);
		// and seed initialVertex's neighbors
		Station initialStation = this.graph.getStation(initialStationId);
		ArrayList<Road> initialStationNeighbors = initialStation.getNeighbors();
		for (Road r : initialStationNeighbors) {
			Station other = r.getNeighbor(initialStation);
			this.predecessors.put(other.getId(), initialStationId);
			this.distances.put(other.getId(), r.getDistance());
			this.availableStations.add(other);
		}
		this.visitedStations.add(initialStation);
		// now apply Dijkstra's algorithm to the Graph
		processGraph();
	}

	private void processGraph() {
		// as long as there are Edges to process
		while (this.availableStations.size() > 0) {
			// pick the cheapest vertex
			Station next = this.availableStations.poll();
			Double distanceToNext = this.distances.get(next.getId());
			// and for each available neighbor of the chosen vertex
			List<Road> nextNeighbors = next.getNeighbors();
			for (Road r : nextNeighbors) {
				Station other = r.getNeighbor(next);
				if (this.visitedStations.contains(other)) {
					continue;
				}
				// we check if a shorter path exists
				// and update to indicate a new shortest found path
				// in the graph
				Double currentDistance = this.distances.get(other.getId());
				Double newDistance = distanceToNext + r.getDistance();
				if (newDistance < currentDistance) {
					this.predecessors.put(other.getId(), next.getId());
					this.distances.put(other.getId(), newDistance);
					this.availableStations.remove(other);
					this.availableStations.add(other);
				}
			}
			// finally, mark the selected vertex as visited
			// so we don't revisit it
			this.visitedStations.add(next);
		}
	}

	public List<Station> getPathTo(Long stationId) {
		LinkedList<Station> path = new LinkedList<Station>();
		path.add(graph.getStation(stationId));
		while (!stationId.equals(this.initialStationId)) {
			Station predecessor = graph.getStation(this.predecessors.get(stationId));
			stationId = predecessor.getId();
			path.add(0, predecessor);
		}
		return path;
	}

	public Double getDistanceTo(Long destinationLabel) {
		this.destinationId = destinationLabel;
		return this.distances.get(destinationLabel);
	}

	public Long getInitialStationId() {
		return initialStationId;
	}

	public Long getDestinationId() {
		return destinationId;
	}
	
}
