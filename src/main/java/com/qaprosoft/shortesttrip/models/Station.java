package com.qaprosoft.shortesttrip.models;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qaprosoft.shortesttrip.models.transport.Bus;
import com.qaprosoft.shortesttrip.models.transport.Train;
import com.qaprosoft.shortesttrip.models.transport.Tram;
import com.qaprosoft.shortesttrip.models.transport.Trolleybus;

public class Station extends AbstractEntity {

	private String name;
	private Long cityId;
	private List<Bus> buses;
	private List<Tram> trams;
	private List<Trolleybus> trolleybuses;
	private List<Train> trains;
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

	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	public List<Tram> getTrams() {
		return trams;
	}

	public void setTrams(List<Tram> trams) {
		this.trams = trams;
	}

	public List<Trolleybus> getTrolleybuses() {
		return trolleybuses;
	}

	public void setTrolleybuses(List<Trolleybus> trolleybuses) {
		this.trolleybuses = trolleybuses;
	}
	
	public List<Train> getTrains() {
		return trains;
	}

	public void setTrains(List<Train> trains) {
		this.trains = trains;
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
