package com.qaprosoft.shortesttrip.service.mybatis.impl;

import java.util.List;
import com.qaprosoft.shortesttrip.models.transport.Tram;
import com.qaprosoft.shortesttrip.service.ITramService;

public class TramService implements ITramService{

	private ITramService tramService = MybatisUtil.getSqlSessionFactory().openSession(true).getMapper(ITramService.class);

	@Override
	public List<Tram> getAll() {
		List<Tram> tramAll = tramService.getAll();
		return tramAll;
	}

	@Override
	public Tram getById(Long id) {
		Tram tram = tramService.getById(id);
		return tram;
	}

	@Override
	public List<Tram> getTramsByStationId(Long id) {
		List<Tram> tramAll = tramService.getTramsByStationId(id);
		return tramAll;
	}

	@Override
	public void delete(Long id) {
		tramService.delete(id);
	}

	@Override
	public void update(Tram tram) {
		tramService.update(tram);
	}

	@Override
	public void create(Tram tram) {
		tramService.create(tram);
	}
}
