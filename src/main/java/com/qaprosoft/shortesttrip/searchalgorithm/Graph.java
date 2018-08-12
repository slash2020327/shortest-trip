package com.qaprosoft.shortesttrip.searchalgorithm;

import java.util.HashSet;
import java.util.Set;
import com.qaprosoft.shortesttrip.models.Station;

public class Graph {
	 
    private Set<Station> stations = new HashSet<>();
     
    public void addStation(Station station) {
        stations.add(station);
    }

	public Set<Station> getStations() {
		return stations;
	}

	public void setStations(Set<Station> stations) {
		this.stations = stations;
	}
}
