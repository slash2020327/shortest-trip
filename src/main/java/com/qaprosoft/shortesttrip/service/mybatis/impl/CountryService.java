package com.qaprosoft.shortesttrip.service.mybatis.impl;

import java.util.List;
import com.qaprosoft.shortesttrip.models.Country;
import com.qaprosoft.shortesttrip.service.ICountryService;

public class CountryService implements ICountryService {

private ICountryService countryService = MybatisUtil.getSqlSessionFactory().openSession(true).getMapper(ICountryService.class);
	
	@Override
	public List<Country> getAll() {
		List<Country> countryAll = countryService.getAll();
		return countryAll;
	}

	@Override
	public Country getById(Long id) {
		Country country = countryService.getById(id);
		return country;
	}
	
	@Override
	public void delete(Long id) {
		countryService.delete(id);
	}

	@Override
	public void update(Country country) {
		countryService.update(country);
	}

	@Override
	public void create(Country country) {
		countryService.create(country);
	}
}
