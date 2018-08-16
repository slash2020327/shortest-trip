package com.qaprosoft.shortesttrip.service;

import java.util.List;

import com.qaprosoft.shortesttrip.models.AbstractEntity;

public interface IAbstractEntity <K, T extends AbstractEntity> {

		List<T> getAll();
		T getById(K id);	
}
