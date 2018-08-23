package com.qaprosoft.shortesttrip.models.transport;

public class Train extends Transport{

	@Override
	public String toString() {
		return "Train [Id=" + getId() + ", Number=" + getNumber() +"]";
	}
}
