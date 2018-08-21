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

	public boolean addRoad(Station one, Station two, Double distance) {
		if (one.equals(two)) {
			return false;
		}
		Road road = new Road(one, two, distance);
		if (roads.containsKey(road.hashCode())) {
			return false;
		}
		else if (one.containsNeighbor(road) || two.containsNeighbor(road)) {
			return false;
		}
		roads.put(road.hashCode(), road);
		one.addNeighbor(road);
		two.addNeighbor(road);
		return true;
	}

	boolean containsRoad(Road r) {
		if (r.getFromStation() == null || r.getToStation() == null) {
			return false;
		}
		return this.roads.containsKey(r.hashCode());
	}

	public Road removeRoad(Road road) {
		road.getFromStation().removeNeighbor(road);
		road.getToStation().removeNeighbor(road);
		return this.roads.remove(road.hashCode());
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
