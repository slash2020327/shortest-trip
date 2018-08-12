package com.qaprosoft.shortesttrip.searchalgorithmtest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

public class Node {

	private String name;

	private List<Node> shortestPath = new LinkedList<>();

	private Integer distance = Integer.MAX_VALUE;

	private HashMap<Node, Integer> adjacentNodes = new HashMap<>();

	public Node(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Node> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(List<Node> shortestPath) {
		this.shortestPath = shortestPath;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public void addDestination(Node destination, int distance) {
		adjacentNodes.put(destination, distance);
	}

	public Map<Node, Integer> getAdjacentNodes() {
		return adjacentNodes;
	}

	public void setAdjacentNodes(HashMap<Node, Integer> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}

	@Override
	public String toString() {
		return "Node [name=" + name + ", distance=" + distance + "]";
	}
	
	
}