package com.qaprosoft.shortesttrip.service;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.MapKey;
import com.qaprosoft.shortesttrip.models.Station;

public interface IStationService {

	List<Station> getAll();

	Station getById(Long id);
	
	List<Station> getStationsByCityId(Long id);

	void delete(Long id);

	void update(Station station);

	void create(Station station);
	
	@MapKey("id")
	HashMap<Station, Double> getAllAdjacentStationsByStationId(Long id);
}
