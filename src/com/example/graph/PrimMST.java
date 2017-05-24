package com.example.graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PrimMST {

	private Edge[] edgeTo;
	private double[] distTo;
	private boolean[] marked;
	private Map<Integer,Double> pq;
	
	public PrimMST(EdgeWeightedGraph g){
		edgeTo = new Edge[g.getVertex()];
		distTo = new double[g.getVertex()];
		marked = new boolean[g.getVertex()];
		for(int v=0;v<g.getVertex();v++){
			distTo[v] = Double.POSITIVE_INFINITY;
		}
		pq = new HashMap<Integer,Double>();
		distTo[0] = 0.0;
		pq.put(0, 0.0);
		while(!pq.isEmpty()){
			double min = Collections.min(pq.values());
			int vertex = 0;
			for(int key : pq.keySet()){
				if(pq.get(key) == min){
					vertex = key;
				}
			}
			pq.remove(vertex);
			visit(g,vertex);
		}
	}

	private void visit(EdgeWeightedGraph g, int v) {
		
		marked[v] = true;
		for(Edge e : g.adj(v)){
			int w = e.other(v);
			if(marked[w]) continue;
			if(e.weight() < distTo[w]){
				edgeTo[w] = e;
				distTo[w] = e.weight();
				if(pq.containsKey(w)) pq.replace(w, distTo[w]);
				else pq.put(w, distTo[w]);
			}
		}
		
	}
	
	public Iterable<Double> edges(){
		return pq.values();
	}
	
	public double weight(){
		double weightSum = 0;
		for(int i=0;i<distTo.length;i++){
			weightSum += distTo[i];
		}
		return weightSum;
	}
	
	public void showPath(){
		for(int i=0;i<edgeTo.length;i++){
			System.out.println(edgeTo[i].either()+"→"+edgeTo[i].other(edgeTo[i].either()));
		}
	}
	
}
