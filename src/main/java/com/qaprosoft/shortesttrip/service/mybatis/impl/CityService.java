package com.qaprosoft.shortesttrip.service.mybatis.impl;

import java.util.List;
import com.qaprosoft.shortesttrip.models.City;
import com.qaprosoft.shortesttrip.service.ICityService;

public class CityService implements ICityService {
	
	private ICityService cityService = MybatisUtil.getSqlSessionFactory().openSession(true).getMapper(ICityService.class);
	
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
	
	@Override
	public List<City> getCitiesByCountryId(Long id) {
		List<City> cityAll = cityService.getCitiesByCountryId(id);
		return cityAll;
	}
	
	@Override
	public void delete(Long id) {
		cityService.delete(id);
	}

	@Override
	public void update(City city) {
		cityService.update(city);
	}

	@Override
	public void create(City city) {
		cityService.create(city);
	}
}


