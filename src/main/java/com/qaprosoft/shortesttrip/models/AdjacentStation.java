package com.qaprosoft.shortesttrip.models;

public class AdjacentStation extends AbstractEntity{
	
	private Station station;
	private Station adjacentStation;
	private Double distanceStation;
	
	public AdjacentStation(Long id, Station station, Station adjacentStation, Double distanceStation) {
		super(id);
		this.station = station;
		this.adjacentStation = adjacentStation;
		this.distanceStation = distanceStation;
	}

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
