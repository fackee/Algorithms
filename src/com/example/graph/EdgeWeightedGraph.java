package com.example.graph;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class EdgeWeightedGraph implements Graph<Edge>{
	
	private int vertex;
	private int edgeCount = 0;
	private Set<Edge>[] edges;
	private boolean[] marked ;
	private List<Edge> allEdge;
	public EdgeWeightedGraph(int vertex){
		this.vertex = vertex;
		marked = new boolean[vertex];
		edges = new HashSet[vertex];
		allEdge = new LinkedList<>();
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

	public Iterable<Edge> edges(){
		for(int i=0;i<vertex;i++){
			for(Edge e : adj(i)){
				if(!allEdge.contains(e)){
					allEdge.add(e);
				}
			}
		}
		Collections.sort(allEdge);
		return allEdge;
	}
	
}
