package com.qaprosoft.shortesttrip.searchalgorithm;

import java.util.*;
import com.qaprosoft.shortesttrip.models.Road;
import com.qaprosoft.shortesttrip.models.Station;
import com.qaprosoft.shortesttrip.models.transport.Transport;

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
			throw new IllegalArgumentException("The graph must contain the initial station");
		}
		this.initialStationId = initialStationId;
		this.predecessors = new HashMap<Long, Long>();
		this.distances = new HashMap<Long, Double>();
		this.availableStations = new PriorityQueue<Station>(stationKeys.size(), new Comparator<Station>() {
			public int compare(Station one, Station two) {
				Double distanceOne = Dijkstra.this.distances.get(one.getId());
				Double distanceTwo = Dijkstra.this.distances.get(two.getId());
				if (distanceOne > distanceTwo)
					return 1;
				if (distanceOne < distanceTwo)
					return -1;
				return 0;
			}
		});
		this.visitedStations = new HashSet<Station>();
		for (Long key : stationKeys) {
			this.predecessors.put(key, null);
			this.distances.put(key, Double.MAX_VALUE);
		}
		this.distances.put(initialStationId, (double) 0);
		Station initialStation = this.graph.getStation(initialStationId);
		ArrayList<Road> initialStationNeighbors = initialStation.getNeighbors();
		for (Road road : initialStationNeighbors) {
			Station other = road.getNeighbor(initialStation);
			this.predecessors.put(other.getId(), initialStationId);
			this.distances.put(other.getId(), road.getDistance());
			this.availableStations.add(other);
		}
		this.visitedStations.add(initialStation);
		processGraph();
	}

	private void processGraph() {
		while (this.availableStations.size() > 0) {
			Station next = this.availableStations.poll();
			Double distanceToNext = this.distances.get(next.getId());
			List<Road> nextNeighbors = next.getNeighbors();
			for (Road road : nextNeighbors) {
				Station other = road.getNeighbor(next);
				if (this.visitedStations.contains(other)) {
					continue;
				}
				Double currentDistance = this.distances.get(other.getId());
				Double newDistance = distanceToNext + road.getDistance();
				if (newDistance < currentDistance) {
					this.predecessors.put(other.getId(), next.getId());
					this.distances.put(other.getId(), newDistance);
					this.availableStations.add(other);
				}
			}
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

	public LinkedHashMap<Station, Transport> setTransport(List<Station> path) {
		LinkedHashMap<Station, Transport> pathWithTransport = new LinkedHashMap<Station, Transport>();
		for (Station station : path) {
			if (station.getTrains().size() > 0) {
				pathWithTransport.put(station, station.getTrains().get(0));
			} if (station.getBuses().size() > 0) {
				pathWithTransport.put(station, station.getBuses().get(0));
			} if (station.getTrams().size() > 0) {
				pathWithTransport.put(station, station.getTrams().get(0));
			} if (station.getTrolleybuses().size() > 0) {
				pathWithTransport.put(station, station.getTrolleybuses().get(0));
			}
		}
		return pathWithTransport;
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
