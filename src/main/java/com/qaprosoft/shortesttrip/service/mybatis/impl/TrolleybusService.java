package com.qaprosoft.shortesttrip.service.mybatis.impl;

import java.util.List;
import com.qaprosoft.shortesttrip.models.transport.Trolleybus;
import com.qaprosoft.shortesttrip.service.ITrolleybusService;

public class TrolleybusService implements ITrolleybusService{

	private ITrolleybusService trolleybusService = MybatisUtil.getSqlSessionFactory().openSession(true).getMapper(ITrolleybusService.class);

	@Override
	public List<Trolleybus> getAll() {
		List<Trolleybus> trolleybusAll = trolleybusService.getAll();
		return trolleybusAll;
	}

	@Override
	public Trolleybus getById(Long id) {
		Trolleybus trolleybus = trolleybusService.getById(id);
		return trolleybus;
	}

	@Override
	public List<Trolleybus> getTrolleybusesByStationId(Long id) {
		List<Trolleybus> trolleybusAll = trolleybusService.getTrolleybusesByStationId(id);
		return trolleybusAll;
	}

	@Override
	public void delete(Long id) {
		trolleybusService.delete(id);
	}

	@Override
	public void update(Trolleybus trolleybus) {
		trolleybusService.update(trolleybus);
	}

	@Override
	public void create(Trolleybus trolleybus) {
		trolleybusService.create(trolleybus);
	}
}
