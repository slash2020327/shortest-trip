package com.qaprosoft.shortesttrip.service;

import java.util.List;
import com.qaprosoft.shortesttrip.models.transport.Trolleybus;

public interface ITrolleybusService {

	List<Trolleybus> getAll();

	Trolleybus getById(Long id);
	
	List<Trolleybus> getTrolleybusesByStationId(Long id);
	
	void delete(Long id);

	void update(Trolleybus trolleybus);

	void create(Trolleybus trolleybus);
}
