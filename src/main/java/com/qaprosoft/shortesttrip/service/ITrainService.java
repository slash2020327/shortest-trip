package com.qaprosoft.shortesttrip.service;

import java.util.List;
import com.qaprosoft.shortesttrip.models.transport.Train;

public interface ITrainService {

	List<Train> getAll();

	Train getById(Long id);
	
	List<Train> getTrainsByStationId(Long id);
	
	void delete(Long id);

	void update(Train train);

	void create(Train train);
}
