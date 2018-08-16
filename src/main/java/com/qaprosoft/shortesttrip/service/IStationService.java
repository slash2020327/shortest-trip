package com.qaprosoft.shortesttrip.service;

import java.util.HashMap;
import org.apache.ibatis.annotations.MapKey;

import com.qaprosoft.shortesttrip.models.Station;


public interface IStationService extends IAbstractEntity <Long, Station>{

	@MapKey("id") 
	HashMap<Station, Double> getAllAdjacentStationsByStationId(Long id);
}
