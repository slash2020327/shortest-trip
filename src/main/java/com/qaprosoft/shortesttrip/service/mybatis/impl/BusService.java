package com.qaprosoft.shortesttrip.service.mybatis.impl;

import java.util.List;
import com.qaprosoft.shortesttrip.models.transport.Bus;
import com.qaprosoft.shortesttrip.service.IBusService;

public class BusService implements IBusService{

	private IBusService busService = MybatisUtil.getSqlSessionFactory().openSession(true).getMapper(IBusService.class);

	@Override
	public List<Bus> getAll() {
		List<Bus> busAll = busService.getAll();
		return busAll;
	}

	@Override
	public Bus getById(Long id) {
		Bus bus = busService.getById(id);
		return bus;
	}

	@Override
	public List<Bus> getBusesByStationId(Long id) {
		List<Bus> busAll = busService.getBusesByStationId(id);
		return busAll;
	}

	@Override
	public void delete(Long id) {
		busService.delete(id);
	}

	@Override
	public void update(Bus bus) {
		busService.update(bus);
	}

	@Override
	public void create(Bus bus) {
		busService.create(bus);
	}
}
