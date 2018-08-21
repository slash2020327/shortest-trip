package com.qaprosoft.shortesttrip.models;

import java.util.List;

public class City extends AbstractEntity {
	
	private String name;
	private Long countryId;
	private List<Station> stationsOfCity;	
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Long getCountyId() {
		return countryId;
	}

	public void setCountyId(Long countyId) {
		this.countryId = countyId;
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
