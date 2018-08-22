package com.qaprosoft.shortesttrip.launch;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.shortesttrip.models.AdjacentStation;
import com.qaprosoft.shortesttrip.models.Road;
import com.qaprosoft.shortesttrip.models.Station;
import com.qaprosoft.shortesttrip.models.transport.CityTransport;
import com.qaprosoft.shortesttrip.searchalgorithm.Dijkstra;
import com.qaprosoft.shortesttrip.searchalgorithm.Graph;
import com.qaprosoft.shortesttrip.service.mybatis.impl.AdjacentStationService;
import com.qaprosoft.shortesttrip.service.mybatis.impl.StationService;

public class Runner {
	private static Logger logger = LogManager.getLogger();
	private static final long START_STATION_ID = 1;
	private static final long DESTINATION_STATION_ID = 20;

	public static void main(String[] args) {
		
		Graph graph = new Graph();

		StationService ss = new StationService();
		List<Station> stations = ss.getAll();		
			for (Station station : stations) {
				graph.addStation(station, true);		    
		    }
		
		AdjacentStationService ass = new AdjacentStationService();
		List<AdjacentStation> adjacentStations = ass.getAll();		
			for (AdjacentStation adjs : adjacentStations) {
				graph.addRoad(adjs.getStation(), adjs.getAdjacentStation(), adjs.getDistanceStation());	
			}
		
		for (Station station : stations) {
			for (Road road : graph.getRoads()) {
				if (station.getId() == road.getFromStation().getId()) {
					station.addNeighbor(road);					
				}
			}
		}			
	
	    Dijkstra dijkstra = new Dijkstra(graph, START_STATION_ID);
	    Double shortDistance = dijkstra.getDistanceTo(DESTINATION_STATION_ID);	    
	    logger.log(Level.INFO, "\n Distance from station with id="+ dijkstra.getInitialStationId()+ 
	    		" to station with id=" + dijkstra.getDestinationId() + " equals "+ shortDistance);
	    
	    logger.log(Level.INFO, "\n Shortest path from station with id="+ dijkstra.getInitialStationId()+ 
				" to station with id=" + dijkstra.getDestinationId() + " crosses next stations : \n"+ dijkstra.getPathTo(dijkstra.getDestinationId()));
	    
	    LinkedHashMap<Station, CityTransport> pathWithTransport = dijkstra.setTransport(dijkstra.getPathTo(dijkstra.getDestinationId()));
	    logger.log(Level.INFO, pathWithTransport);
	    
	}
}
