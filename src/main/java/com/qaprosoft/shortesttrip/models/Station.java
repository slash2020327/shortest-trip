package com.qaprosoft.shortesttrip.models;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Station extends AbstractEntity {

	private String name;
	private Long cityId;
	@JsonIgnore
	private ArrayList<Road> neighborhood = new ArrayList<Road>();

	public Station() {
	}

	public Station(Long id, String name) {
		super(id);
		this.name = name;
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

	public void addNeighbor(Road road) {
		 if (this.neighborhood.contains(road)) {
		 return;
		 }
		this.neighborhood.add(road);
	}

	public boolean containsNeighbor(Road other) {
		return this.neighborhood.contains(other);
	}

	public Road getNeighbor(int index) {
		return this.neighborhood.get(index);
	}

	Road removeNeighbor(int index) {
		return this.neighborhood.remove(index);
	}

	public void removeNeighbor(Road e) {
		this.neighborhood.remove(e);
	}

	@JsonIgnore
	public int getNeighborCount() {
		return this.neighborhood.size();
	}

	public boolean equals(Object other) {
		if (!(other instanceof Road)) {
			return false;
		}
		Road v = (Road) other;
		return this.getId().equals(v.getToStation().getId());
	}

	@JsonIgnore
	public ArrayList<Road> getNeighbors() {
		return new ArrayList<Road>(this.neighborhood);
	}

	@Override
	public String toString() {
		return "Station [name=" + name + ", cityId=" + cityId + ", stationId=" + getId() + "]";
	}
}
