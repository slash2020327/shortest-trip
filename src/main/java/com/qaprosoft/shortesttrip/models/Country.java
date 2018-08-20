package com.qaprosoft.shortesttrip.models;

import java.util.List;

public class Country extends AbstractEntity{

	private String name;
	private List<City> cities;

	public String getCountryName() {
		return name;
	}

	public void setCountryName(String countryName) {
		this.name = countryName;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "Country [id=" + getId() + ", name=" + name + "]";
	}

}
