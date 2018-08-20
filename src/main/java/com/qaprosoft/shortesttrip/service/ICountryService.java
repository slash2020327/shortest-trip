package com.qaprosoft.shortesttrip.service;

import java.util.List;
import com.qaprosoft.shortesttrip.models.Country;

public interface ICountryService {

	List<Country> getAll();

	Country getById(Long id);
	
	void delete(Long id);

	void update(Country country);

	void create(Country country);
}
