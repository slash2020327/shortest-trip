package com.qaprosoft.shortesttrip.launch;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.shortesttrip.models.AdjacentStation;
import com.qaprosoft.shortesttrip.models.Station;
import com.qaprosoft.shortesttrip.searchalgorithm.Dijkstra;
import com.qaprosoft.shortesttrip.searchalgorithm.Graph;
import com.qaprosoft.shortesttrip.service.mybatis.impl.AdjacentStationService;
import com.qaprosoft.shortesttrip.service.mybatis.impl.StationService;

public class Runner {
	private static Logger logger = LogManager.getLogger();

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
		logger.log(Level.INFO, "\n All roads of the Graph = \n" + graph.getRoads());
		
	    Dijkstra dijkstra = new Dijkstra(graph, (long) 1);
	    Double shortDistance = dijkstra.getDistanceTo((long) 5);	    
	    logger.log(Level.INFO, "\n Distance from station with id="+ dijkstra.getInitialStationId()+ 
	    		" to station with id=" + dijkstra.getDestinationId() + " equals "+ shortDistance);
	    
	    
	    logger.log(Level.INFO, "\n Shortest path from station with id "+ dijkstra.getInitialStationId()+ 
				" to station with id=" + dijkstra.getDestinationId() + " crosses next stations : "+ dijkstra.getPathTo(dijkstra.getDestinationId()));
	    
	}
}
