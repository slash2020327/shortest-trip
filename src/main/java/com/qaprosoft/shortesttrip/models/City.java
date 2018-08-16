package com.qaprosoft.shortesttrip.models;

import java.util.List;

public class City extends AbstractEntity {
	
	private String name;
	private List<Station> stationsOfCity;
	
	public City() {		
	}
	
	public City (Long id, String name) {
		super(id);
		this.name = name;		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Station> getStationsOfCity() {
		return stationsOfCity;
	}

	public void setStationsOfCity(List<Station> stationsOfCity) {
		this.stationsOfCity = stationsOfCity;
	}

	@Override
	public String toString() {
		return "City [Id=" + getId() + ", name=" + name + ", stationsOfCity" + stationsOfCity + "]";
	}	
	
}
