package com.qaprosoft.shortesttrip.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import com.qaprosoft.shortesttrip.models.Station;

public interface IStationService {

	List<Station> getAll();

	Station getStationById(Long id);
	
	@MapKey("id") 
	HashMap<Station, Double> getAllAdjacentStationsByStationId(Long id);
}
