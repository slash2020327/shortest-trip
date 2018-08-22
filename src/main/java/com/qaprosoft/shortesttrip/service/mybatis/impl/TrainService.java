package com.qaprosoft.shortesttrip.service.mybatis.impl;

import java.util.List;
import com.qaprosoft.shortesttrip.models.transport.Train;
import com.qaprosoft.shortesttrip.service.ITrainService;

public class TrainService implements ITrainService{

	private ITrainService tramService = MybatisUtil.getSqlSessionFactory().openSession(true).getMapper(ITrainService.class);

	@Override
	public List<Train> getAll() {
		List<Train> trainAll = tramService.getAll();
		return trainAll;
	}

	@Override
	public Train getById(Long id) {
		Train train = tramService.getById(id);
		return train;
	}

	@Override
	public List<Train> getTrainsByStationId(Long id) {
		List<Train> trainAll = tramService.getTrainsByStationId(id);
		return trainAll;
	}

	@Override
	public void delete(Long id) {
		tramService.delete(id);
	}

	@Override
	public void update(Train train) {
		tramService.update(train);
	}

	@Override
	public void create(Train train) {
		tramService.create(train);
	}
}
