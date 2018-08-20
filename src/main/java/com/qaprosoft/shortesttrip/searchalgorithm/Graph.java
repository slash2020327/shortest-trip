package com.qaprosoft.shortesttrip.searchalgorithm;

import java.util.*;

import com.qaprosoft.shortesttrip.models.Road;
import com.qaprosoft.shortesttrip.models.Station;

public class Graph {
	private HashMap<Long, Station> stations;
	private HashMap<Integer, Road> roads;

	public Graph() {
		this.stations = new HashMap<Long, Station>();
		this.roads = new HashMap<Integer, Road>();
	}

	public Graph(ArrayList<Station> stations) {
		this.stations = new HashMap<Long, Station>();
		this.roads = new HashMap<Integer, Road>();
		for (Station s : stations) {
			this.stations.put(s.getId(), s);
		}
	}

//	public boolean addRoad(Station one, Station two) {
//		return addRoad(one, two, (double) 1);
//	}

	public boolean addRoad(Station one, Station two, Double distance) {
		if (one.equals(two)) {
			return false;
		}
		// ensures the Edge is not in the Graph
		Road r = new Road(one, two, distance);
		if (roads.containsKey(r.hashCode())) {
			return false;
		}
		// and that the Edge isn't already incident to one of the vertices
		else if (one.containsNeighbor(r) || two.containsNeighbor(r)) {
			return false;
		}
		roads.put(r.hashCode(), r);
		one.addNeighbor(r);
		two.addNeighbor(r);
		return true;
	}

	boolean containsRoad(Road r) {
		if (r.getFromStation() == null || r.getToStation() == null) {
			return false;
		}
		return this.roads.containsKey(r.hashCode());
	}

	public Road removeRoad(Road r) {
		r.getFromStation().removeNeighbor(r);
		r.getToStation().removeNeighbor(r);
		return this.roads.remove(r.hashCode());
	}

	public boolean containsStation(Station station) {
		return this.stations.get(station.getId()) != null;
	}

	public Station getStation(Long id) {
		return stations.get(id);
	}

	public boolean addStation(Station station, boolean overwriteExisting) {
		Station current = this.stations.get(station.getId());
		if (current != null) {
			if (!overwriteExisting) {
				return false;
			}
			while (current.getNeighborCount() > 0) {
				this.removeRoad(current.getNeighbor(0));
			}
		}
		stations.put(station.getId(), station);
		return true;
	}

	public Station removeStation(Long id) {
		Station s = stations.remove(id);
		while (s.getNeighborCount() > 0) {
			this.removeRoad(s.getNeighbor((0)));
		}
		return s;
	}

	public Set<Long> stationKeys() {
		return this.stations.keySet();
	}

	public Set<Road> getRoads() {
		return new HashSet<Road>(this.roads.values());
	}
}
