package com.qaprosoft.shortesttrip.service.mybatis.impl;

import java.util.List;

import com.qaprosoft.shortesttrip.models.transport.Taxi;
import com.qaprosoft.shortesttrip.service.ITaxiService;

public class TaxiService implements ITaxiService{
	
	private ITaxiService taxiService = MybatisUtil.getSqlSessionFactory().openSession(true).getMapper(ITaxiService.class);	
	
	@Override
	public List<Taxi> getAll() {
		List<Taxi> taxiAll = taxiService.getAll();
		return taxiAll;
	}

	@Override
	public Taxi getById(Long id) {
		Taxi taxi = taxiService.getById(id);
		return taxi;
	}

	@Override
	public List<Taxi> getTaxiByStationId(Long id) {
		List<Taxi> taxiAll = taxiService.getTaxiByStationId(id);
		return taxiAll;
	}

	@Override
	public void delete(Long id) {
		taxiService.delete(id);		
	}

	@Override
	public void update(Taxi taxi) {
		taxiService.update(taxi);		
	}

	@Override
	public void create(Taxi taxi) {
		taxiService.create(taxi);		
	}
	
	

}
