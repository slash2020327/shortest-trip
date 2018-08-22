package com.qaprosoft.shortesttrip.service;

import java.util.List;
import com.qaprosoft.shortesttrip.models.transport.Bus;

public interface IBusService {

	List<Bus> getAll();

	Bus getById(Long id);
	
	List<Bus> getBusesByStationId(Long id);
	
	void delete(Long id);

	void update(Bus bus);

	void create(Bus bus);
}
