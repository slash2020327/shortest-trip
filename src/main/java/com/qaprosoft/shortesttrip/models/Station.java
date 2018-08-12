package com.qaprosoft.shortesttrip.models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.qaprosoft.shortesttrip.searchalgorithmtest.Node;

public class Station extends AbstractEntity {

	private String name;
	private Integer cityId;
	private Double distance = Double.MAX_VALUE;
	private HashMap<Station, Double> adjacentStations = new HashMap<>();
	private List<Station> shortestPath = new LinkedList<>();

	public List<Station> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(List<Station> shortestPath) {
		this.shortestPath = shortestPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Double getDistance() {
		return distance;
	}

	@Override
	public String toString() {
		return "Station [name=" + name + ", cityId=" + cityId + ", distance=" + distance + ", getId()=" + getId() + "]";
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public HashMap<Station, Double> getAdjacentStations() {
		return adjacentStations;
	}

	public void setAdjacentStations(HashMap<Station, Double> adjacentStations) {
		this.adjacentStations = adjacentStations;
	}

	public void addDestination(Station destination, Double distance) {
		adjacentStations.put(destination, distance);
	}
	

}
