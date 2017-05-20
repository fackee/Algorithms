package com.example.graph;

import java.util.HashSet;
import java.util.Set;

public class EdgeWeightedGraph implements Graph<Edge>{
	
	private int vertex;
	private int edgeCount = 0;
	private Set<Edge>[] edges;
	
	public EdgeWeightedGraph(int vertex){
		this.vertex = vertex;
		edges = new HashSet[vertex];
		for(int v=0;v<vertex;v++){
			edges[v] = new HashSet<Edge>();
		}
	}
	
	@Override
	public EdgeWeightedGraph init(int edgeCount){
		this.edgeCount = edgeCount;
		for(int e = 0;e<edgeCount;e++){
			addEdge(new Edge());
		}
		return this;
	}
	
	@Override
	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		edges[v].add(e);
		edges[w].add(e);
		edgeCount++;
		
	}
	
	@Override
	public int getVertex() {
		return vertex;
	}

	@Override
	public int getEdge() {
		return edgeCount;
	}

	@Override
	public Iterable<Edge> adj(int v) {
		return edges[v];
	}

	
}
