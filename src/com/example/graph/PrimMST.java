package com.example.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PrimMST {

	private Edge[] edgeTo;
	private double[] distTo;
	private boolean[] marked;
	private List<Double> pq;
	
	public PrimMST(EdgeWeightedGraph g){
		edgeTo = new Edge[g.getVertex()];
		distTo = new double[g.getVertex()];
		marked = new boolean[g.getVertex()];
		for(int v=0;v<g.getVertex();v++){
			distTo[v] = Double.POSITIVE_INFINITY;
		}
		pq = new ArrayList<Double>(g.getVertex());
		pq.add(0, 0.0);
		while(!pq.isEmpty()){
			double min = Collections.min(pq);
			int vertex = pq.indexOf(min);
			pq.remove(min);
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
				pq.add(w, distTo[w]);
			}
		}
		
	}
	
	public Iterable<Double> edges(){
		return pq;
	}
	
	public double weight(){
		Iterator<Double> it = pq.iterator();
		double weightSum = 0.00;
		while(it.hasNext()){
			weightSum += it.next();
		}
		return weightSum;
	}
	
}
