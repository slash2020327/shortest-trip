package com.qaprosoft.shortesttrip.service.mybatis.impl;

import java.util.List;

import com.qaprosoft.shortesttrip.models.City;
import com.qaprosoft.shortesttrip.service.ICityService;

public class CityService implements ICityService {
	
	private ICityService cityService = MybatisUtil.getSqlSessionFactory().openSession().getMapper(ICityService.class);
	
	@Override
	public List<City> getAll() {
		List<City> cityAll = cityService.getAll();
		return cityAll;
	}

	@Override
	public City getById(Long id) {
		City city = cityService.getById(id);
		return city;
	}
}


