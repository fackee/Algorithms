package com.example.graph;

public class TransitiveClosure {

	private DepthFirstSearch[] all;
	
	public TransitiveClosure(Digraph g){
		all = new DepthFirstSearch[g.getVertex()];
		for(int v=0;v<g.getVertex();v++){
			all[v] = new DepthFirstSearch(g,v);
		}
	}
	
	public boolean reachable(int v,int w){
		return all[v].hashPathTo(w);
	}
}
