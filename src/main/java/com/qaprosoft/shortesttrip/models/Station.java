package com.qaprosoft.shortesttrip.models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Station extends AbstractEntity {
	
	private String name;
	private Long cityId;
	private Double distanceFromSource = Double.MAX_VALUE;
	private HashMap<Station, Double> adjacentStations = new HashMap<>();
	private List<Station> shortestPathFromSource = new LinkedList<>();
	
	public Station() {		
	}

	public Station(Long id, String name) {
		super(id);
		this.name = name;
	}
	
	public List<Station> getShortestPath() {
		return shortestPathFromSource;
	}

	public void setShortestPath(List<Station> shortestPath) {
		this.shortestPathFromSource = shortestPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Double getDistance() {
		return distanceFromSource;
	}

	@Override
	public String toString() {
		return "Station [Id=" + getId() + ", name=" + name + ", cityId=" + cityId + ", distance=" + distanceFromSource + "]";
	}

	public void setDistance(Double distance) {
		this.distanceFromSource = distance;
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
