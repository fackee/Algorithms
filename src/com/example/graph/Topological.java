package com.example.graph;

public class Topological {

	private Iterable<Integer> order;
	public Topological(Digraph g){
		DirectedCycle cycle = new DirectedCycle(g);
		if(!cycle.hasCycle()){
			DepthFirstOrder dfo = new DepthFirstOrder(g);
			order = dfo.reservePost();
		}
	}
	
	public Iterable<Integer> order(){
		return order;
	}
	
	public boolean isDAG(){
		return order!=null;
	}
}
