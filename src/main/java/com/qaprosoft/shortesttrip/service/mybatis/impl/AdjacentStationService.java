package com.qaprosoft.shortesttrip.service.mybatis.impl;

import java.util.List;

import com.qaprosoft.shortesttrip.models.AdjacentStation;
import com.qaprosoft.shortesttrip.service.IAdjacentStationService;

public class AdjacentStationService implements IAdjacentStationService{

private IAdjacentStationService adjacentStationService = MybatisUtil.getSqlSessionFactory().openSession().getMapper(IAdjacentStationService.class);
	
	@Override
	public List<AdjacentStation> getAll() {
		List<AdjacentStation> adjacentStationAll = adjacentStationService.getAll();
		return adjacentStationAll;
	}

	@Override
	public AdjacentStation getById(Long id) {
		AdjacentStation adjacentStation = adjacentStationService.getById(id);
		return adjacentStation;
	}
	
}
