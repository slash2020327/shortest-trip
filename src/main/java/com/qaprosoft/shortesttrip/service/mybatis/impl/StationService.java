package com.qaprosoft.shortesttrip.service.mybatis.impl;

import java.util.HashMap;
import java.util.List;
import com.qaprosoft.shortesttrip.models.Station;
import com.qaprosoft.shortesttrip.service.IStationService;

public class StationService implements IStationService {

	private IStationService stationService = MybatisUtil.getSqlSessionFactory().openSession(true).getMapper(IStationService.class);

	@Override
	public Station getById(Long id) {
		Station station = stationService.getById(id);
		return station;
	}

	@Override
	public List<Station> getAll() {
		List<Station> stations = stationService.getAll();
		return stations;
	}
	
	@Override
	public List<Station> getStationsByCityId(Long id) {
		List<Station> stations = stationService.getStationsByCityId(id);
		return stations;
	}
	
	@Override
	public HashMap<Station, Double> getAllAdjacentStationsByStationId(Long id) {
		HashMap<Station, Double> stations = stationService.getAllAdjacentStationsByStationId(id);
		return stations;
	}
	
	@Override
	public void delete(Long id) {
		stationService.delete(id);
	}

	@Override
	public void update(Station station) {
		stationService.update(station);
	}

	@Override
	public void create(Station station) {
		stationService.create(station);
	}
}