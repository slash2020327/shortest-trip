package com.qaprosoft.shortesttrip.searchalgorithmtesttwo;

import java.util.ArrayList;

public class Vertex {
	private ArrayList<Edge> neighborhood;
	private String label;

	/**
	 * 019
	 *
	 * 020
	 * 
	 * @param label
	 *            The unique label associated with this Vertex 021
	 */
	public Vertex(String label) {
		this.label = label;
		this.neighborhood = new ArrayList<Edge>();
	}

	/**
	 * 029 This method adds an Edge to the incidence neighborhood of this graph iff
	 * 030 the edge is not already present. 031
	 *
	 * 032
	 * 
	 * @param edge
	 *            The edge to add 033
	 */
	public void addNeighbor(Edge edge) {
		if (this.neighborhood.contains(edge)) {
			return;
		}
		this.neighborhood.add(edge);
	}

	/**
	 * 044
	 *
	 * 045
	 * 
	 * @param other
	 *            The edge for which to search 046
	 * @return true iff other is contained in this.neighborhood 047
	 */
	public boolean containsNeighbor(Edge other) {
		return this.neighborhood.contains(other);
	}

	/**
	 * 053
	 *
	 * 054
	 * 
	 * @param index
	 *            The index of the Edge to retrieve 055
	 * @return Edge The Edge at the specified index in this.neighborhood 056
	 */
	public Edge getNeighbor(int index) {
		return this.neighborhood.get(index);
	}

	/**
	 * 063
	 *
	 * 064
	 * 
	 * @param index
	 *            The index of the edge to remove from this.neighborhood 065
	 * @return Edge The removed Edge 066
	 */
	Edge removeNeighbor(int index) {
		return this.neighborhood.remove(index);
	}

	/**
	 * 072
	 *
	 * 073
	 * 
	 * @param e
	 *            The Edge to remove from this.neighborhood 074
	 */
	public void removeNeighbor(Edge e) {
		this.neighborhood.remove(e);
	}

	/**
	 * 081
	 *
	 * 082
	 * 
	 * @return int The number of neighbors of this Vertex 083
	 */
	public int getNeighborCount() {
		return this.neighborhood.size();
	}

	/**
	 * 090
	 *
	 * 091
	 * 
	 * @return String The label of this Vertex 092
	 */
	public String getLabel() {
		return this.label;
	}

	/**
	 * 099
	 *
	 * 100
	 * 
	 * @return String A String representation of this Vertex 101
	 */
	public String toString() {
		return "Vertex " + label;
	}

	/**
	 * 107
	 *
	 * 108
	 * 
	 * @return The hash code of this Vertex's label 109
	 */
	public int hashCode() {
		return this.label.hashCode();
	}

	/**
	 * 115
	 *
	 * 116
	 * 
	 * @param other
	 *            The object to compare 117
	 * @return true iff other instanceof Vertex and the two Vertex objects have the
	 *         same label 118
	 */
	public boolean equals(Object other) {
		if (!(other instanceof Vertex)) {
			return false;
		}
		Vertex v = (Vertex) other;
		return this.label.equals(v.label);
	}

	/**
	 * 129
	 *
	 * 130
	 * 
	 * @return ArrayList<Edge> A copy of this.neighborhood. Modifying the returned
	 *         131 ArrayList will not affect the neighborhood of this Vertex 132
	 */
	public ArrayList<Edge> getNeighbors() {
		return new ArrayList<Edge>(this.neighborhood);
	}
}
