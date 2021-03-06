package com.qaprosoft.shortesttrip.service;

import java.util.List;

import com.qaprosoft.shortesttrip.models.AdjacentStation;

public interface IAdjacentStationService {
	
	List<AdjacentStation> getAll();

	AdjacentStation getById(Long id);
	
	void delete(Long id);

	void update(AdjacentStation adjacentStation);

	void create(AdjacentStation adjacentStation);
}
