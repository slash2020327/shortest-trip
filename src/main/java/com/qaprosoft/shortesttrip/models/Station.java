package com.qaprosoft.shortesttrip.models;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Station extends AbstractEntity {

	private String name;
	private Long cityId;
	@JsonIgnore
	private ArrayList<Road> neighborhood = new ArrayList<Road>();
	
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
		 if (neighborhood.contains(road)) {
		 return;
		 }
		neighborhood.add(road);
	}

	public boolean containsNeighbor(Road other) {
		return neighborhood.contains(other);
	}

	public Road getNeighbor(int index) {
		return neighborhood.get(index);
	}

	Road removeNeighbor(int index) {
		return neighborhood.remove(index);
	}

	public void removeNeighbor(Road e) {
		neighborhood.remove(e);
	}

	@JsonIgnore
	public int getNeighborCount() {
		return neighborhood.size();
	}
	public int hashCode() {
		return getId().hashCode();
	} 
	
	public boolean equals(Object other) {
		if (!(other instanceof Station)) {
			return false;
		}
		Station st = (Station) other;
		return getId().equals(st.getId());
	}

	@JsonIgnore
	public ArrayList<Road> getNeighbors() {
		return new ArrayList<Road>(neighborhood);
	}

	@Override
	public String toString() {
		return "Station [Id=" + getId()+", name=" + name + ", cityId=" + cityId + "]";
	}
}
