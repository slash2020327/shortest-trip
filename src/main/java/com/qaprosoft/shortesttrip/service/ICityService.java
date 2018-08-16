package com.qaprosoft.shortesttrip.service;

import java.util.List;
import com.qaprosoft.shortesttrip.models.City;

public interface ICityService {

	List<City> getAll();

	City getById(Long id);
}
