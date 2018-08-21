package com.qaprosoft.shortesttrip.models;

public class Road implements Comparable<Road>{

	private Station fromStation;
	private Station toStation;
	private Double distance;
	
	public Road() {		
	}
	
	public Road(Station fromStation, Station toStation, Double distance) {
		this.fromStation = (fromStation.getId().compareTo(toStation.getId()) <= 0) ? fromStation : toStation;
		this.toStation = (this.fromStation == fromStation) ? toStation : fromStation;
		this.distance = distance;
	}
	
	public Station getNeighbor(Station current) {
		if (!(current.equals(fromStation) || current.equals(toStation))) {
			return null;
		}
		return (current.equals(fromStation)) ? toStation : fromStation;
	}

	public int compareTo(Road other) {
		if (this.distance > other.distance) return 1;
		if (this.distance < other.distance) return -1;
		return 0;
	}

	public int hashCode() {
		return fromStation.getId().hashCode()*31 + toStation.getId().hashCode();
	}

	public boolean equals(Object other) {
		if (!(other instanceof Road)) {
			return false;
		}
		Road e = (Road) other;
		return e.fromStation.equals(this.fromStation) && e.toStation.equals(this.toStation);
	}
	
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

	@Override
	public String toString() {
		return "Road [fromStation=" + fromStation + ", toStation=" + toStation + ", distance=" + distance + "]";
	}
	
	
}
