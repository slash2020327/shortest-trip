package com.qaprosoft.shortesttrip.models;

import java.util.LinkedHashMap;
import com.qaprosoft.shortesttrip.models.transport.Transport;

public class Path {

	private LinkedHashMap<Station, Transport> path;

	public LinkedHashMap<Station, Transport> getPath() {
		return path;
	}

	public void setPath(LinkedHashMap<Station, Transport> path) {
		this.path = path;
	}
}
