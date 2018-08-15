package com.qaprosoft.shortesttrip.models;

public class Road {

	private Station fromStation;
	private Station toStation;
	private Double distance;
	public Station getFromStation() {
		return fromStation;
	}
	public void setFromStation(Station fromStation) {
		this.fromStation = fromStation;
	}
	public Station getToStation() {
		return toStation;
	}
	public void setToStation(Station toStation) {
		this.toStation = toStation;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
	
}
