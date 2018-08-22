package com.qaprosoft.shortesttrip.service;

import java.util.List;
import com.qaprosoft.shortesttrip.models.transport.Tram;

public interface ITramService {

	List<Tram> getAll();

	Tram getById(Long id);
	
	List<Tram> getTramsByStationId(Long id);
	
	void delete(Long id);

	void update(Tram tram);

	void create(Tram tram);
}
