package com.qaprosoft.shortesttrip.launch;

import java.util.ArrayList;
import java.util.List;
import com.qaprosoft.shortesttrip.models.AdjacentStation;
import com.qaprosoft.shortesttrip.models.Road;
import com.qaprosoft.shortesttrip.models.Station;
import com.qaprosoft.shortesttrip.searchalgorithm.Dijkstra;
import com.qaprosoft.shortesttrip.searchalgorithm.Graph;
import com.qaprosoft.shortesttrip.service.mybatis.impl.AdjacentStationService;
import com.qaprosoft.shortesttrip.service.mybatis.impl.StationService;

public class Runner {

	public static void main(String[] args) {

		
		Graph graph = new Graph();
		
		AdjacentStationService ass = new AdjacentStationService();
		ArrayList<Road> roads = new ArrayList<Road>();
		List<AdjacentStation> adj = ass.getAll();
		 StationService ss = new StationService();
		    List<Station> stations = ss.getAll();
		    for (Station station:stations) {
		    graph.addStation(station, true);
		    
		    }
		for (AdjacentStation adjacentStation : adj) {
			Road road = new Road();
			road.setFromStation(adjacentStation.getStation());
			road.setToStation(adjacentStation.getAdjacentStation());
			road.setDistance(adjacentStation.getDistanceStation());
			roads.add(road);
		}
		System.out.println(roads);
	    for (Road road:roads) {
//	    	System.out.println(road.getFromStation());
//	    	System.out.println(road.getToStation());
//	    	System.out.println(road.getDistance());
	    	 graph.addRoad(road.getFromStation(), road.getToStation(), road.getDistance());	
	    }
	    Dijkstra dijkstra = new Dijkstra(graph, (long) 1);
        System.out.println(dijkstra.getDistanceTo((long) 5));
        System.out.println(dijkstra.getPathTo((long) 5));
	}
}
