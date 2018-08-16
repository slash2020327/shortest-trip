package com.qaprosoft.shortesttrip.models;

public class AdjacentStation extends AbstractEntity{
	
	private Station station;
	private Station adjacentStation;
	private Double distanceStation;

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public Station getAdjacentStation() {
		return adjacentStation;
	}

	public void setAdjacentStation(Station adjacentStation) {
		this.adjacentStation = adjacentStation;
	}

	public Double getDistanceStation() {
		return distanceStation;
	}

	public void setDistanceStation(Double distanceStation) {
		this.distanceStation = distanceStation;
	}
	
	
	
}
