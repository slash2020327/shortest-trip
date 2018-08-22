package com.qaprosoft.shortesttrip.models.transport;

import java.util.List;
import com.qaprosoft.shortesttrip.models.AbstractEntity;
import com.qaprosoft.shortesttrip.models.Station;

public abstract class CityTransport extends AbstractEntity {

	private Integer number;
	private List<Station> stations;
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public List<Station> getStations() {
		return stations;
	}
	public void setStations(List<Station> stations) {
		this.stations = stations;
	}
}
