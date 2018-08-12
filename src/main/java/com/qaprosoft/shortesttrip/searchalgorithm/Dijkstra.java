package com.qaprosoft.shortesttrip.searchalgorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

import com.qaprosoft.shortesttrip.models.Path;
import com.qaprosoft.shortesttrip.models.Station;

public class Dijkstra {

	public static Graph calculateShortestPathFromSource(Graph graph, Station source) {
	    source.setDistance((double) 0);
	 
	    Set<Station> settledStations = new HashSet<>();
	    Set<Station> unsettledStations = new HashSet<>();
	 
	    unsettledStations.add(source);
	 
	    while (unsettledStations.size() != 0) {
	        Station currentStation = getLowestDistanceNode(unsettledStations);
	        unsettledStations.remove(currentStation);
	        for (Entry <Station,Double> adjacencyPair: 
	          currentStation.getAdjacentStations().entrySet()) {
	            Station adjacentNode = adjacencyPair.getKey();
	            Double edgeWeight = adjacencyPair.getValue();
	            if (!settledStations.contains(adjacentNode)) {
	                calculateMinimumDistance(adjacentNode, edgeWeight, currentStation);
	                unsettledStations.add(adjacentNode);
	            }
	        }
	        settledStations.add(currentStation);
	    }
	    return graph;
	}
	
	private static Station getLowestDistanceNode(Set<Station> unsettledStations) {
	    Station lowestDistanceStation = null;
	    double lowestDistance = Double.MAX_VALUE;
	    for (Station station: unsettledStations) {
	        double stationDistance = station.getDistance();
	        if (stationDistance < lowestDistance) {
	            lowestDistance = stationDistance;
	            lowestDistanceStation = station;
	        }
	    }
	    return lowestDistanceStation;
	}
	
	private static void calculateMinimumDistance(Station evaluationStation, Double edgeWeigh, Station sourceStation) {
			    Double sourceDistance = sourceStation.getDistance();
			    if (sourceDistance + edgeWeigh < evaluationStation.getDistance()) {
			        evaluationStation.setDistance(sourceDistance + edgeWeigh);
			        LinkedList<Station> shortestPath = new LinkedList<>(sourceStation.getShortestPath());
			        shortestPath.add(sourceStation);
			        evaluationStation.setShortestPath(shortestPath);
			    }
			}
}
