package com.qaprosoft.shortesttrip.service;

import java.util.List;

import com.qaprosoft.shortesttrip.models.transport.Taxi;

public interface ITaxiService {

	List<Taxi> getAll();

	Taxi getById(Long id);
	
	List<Taxi> getTaxiByStationId(Long id);
	
	void delete(Long id);

	void update(Taxi taxi);

	void create(Taxi taxi);
	
}
