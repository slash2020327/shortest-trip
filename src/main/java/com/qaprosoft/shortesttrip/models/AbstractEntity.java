package com.qaprosoft.shortesttrip.models;

public abstract class AbstractEntity {

	private Long id;
	
	public AbstractEntity() {	
	}
	
	public AbstractEntity(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
