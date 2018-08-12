package com.qaprosoft.shortesttrip.models;

import java.util.LinkedList;
import java.util.List;

public class Path {

	private List<Station> shortestPath = new LinkedList<>();

	public List<Station> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(List<Station> shortestPath) {
		this.shortestPath = shortestPath;
	}
	
	
}
