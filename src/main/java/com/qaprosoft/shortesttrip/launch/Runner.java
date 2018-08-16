package com.qaprosoft.shortesttrip.launch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.qaprosoft.shortesttrip.models.AdjacentStation;
import com.qaprosoft.shortesttrip.models.Road;
import com.qaprosoft.shortesttrip.models.Station;
import com.qaprosoft.shortesttrip.searchalgorithmtest.Dijkstra;
import com.qaprosoft.shortesttrip.searchalgorithmtest.Graph;
import com.qaprosoft.shortesttrip.searchalgorithmtest.Node;
import com.qaprosoft.shortesttrip.service.mybatis.impl.AdjacentStationService;
import com.qaprosoft.shortesttrip.service.mybatis.impl.StationService;

public class Runner {

	public static void main(String[] args) {
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");

		nodeA.addDestination(nodeB, 10);
		nodeA.addDestination(nodeC, 15);

		nodeB.addDestination(nodeD, 12);
		nodeB.addDestination(nodeF, 15);

		nodeC.addDestination(nodeE, 10);

		nodeD.addDestination(nodeE, 2);
		nodeD.addDestination(nodeF, 1);

		nodeF.addDestination(nodeE, 5);

		Graph graph = new Graph();

		graph.addNode(nodeA);
		graph.addNode(nodeB);
		graph.addNode(nodeC);
		graph.addNode(nodeD);
		graph.addNode(nodeE);
		graph.addNode(nodeF);

		graph = Dijkstra.calculateShortestPathFromSource(graph, nodeA);
		Set<Node> nodes = graph.getNodes();
		for (Node node:nodes) {
			List<Node> shortestPath = node.getShortestPath();
			System.out.println(shortestPath);
		}
		
//		StationService ss = new StationService();
//		List<Station> stations = ss.getAll();
////		for (Station station:stations) {
////			HashMap<Station, Double> adjacentStations = ss.getAllAdjacentStationsByStationId(station.getId());
////			for(Map.Entry<Station, Double> entry : adjacentStations.entrySet()) {
////			    Station key = entry.getKey();
////			    Double value = entry.getValue();
////			    station.addDestination(key, value);
////			}
////		}
//		Set<Station> stationsConvert = new HashSet<>(stations);
//		Graph graph = new Graph();
//	    graph.setStations(stationsConvert);
//		HashMap<Station, Double> adjacentStations = ss.getAllAdjacentStationsByStationId((long) 1);
//		System.out.println(adjacentStations);
		
		AdjacentStationService ass = new AdjacentStationService();
		
		ArrayList<Road> roads = new ArrayList<Road>();
		
		for (AdjacentStation adjacentStation : ass.getAll()) {
			Road road = new Road (adjacentStation.getStation(), adjacentStation.getAdjacentStation(), adjacentStation.getDistanceStation());
			roads.add(road);
		}
				
	}
}
