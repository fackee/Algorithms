package com.example.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.example.linkedlist.LinkedQueue;

public class LazyPrimMST {

	private boolean[] marked;
	private LinkedQueue<Edge> mst;
	private List<Edge> pq;
	
	public LazyPrimMST(EdgeWeightedGraph g){
		marked = new boolean[g.getVertex()];
		mst = new LinkedQueue<>();
		pq = new ArrayList<>();
		visite(g,0);
		while(!pq.isEmpty()){
			Edge e = Collections.min(pq);
			pq.remove(e);
			int v = e.either();
			int w = e.other(v);
			if(marked[v] && marked[w]) continue;
			mst.enqueue(e);
			if(!marked[v]) visite(g,v);
			if(!marked[w]) visite(g,w);
		}
	}
	
	private void visite(EdgeWeightedGraph g,int v){
		marked[v] = true;
		
		for(Edge e: g.adj(v)){
			if(!marked[e.other(v)]){
				pq.add(e);
			}
		}
	}
	
	public Iterable<Edge> edges(){
		return mst;
	}
	
	public double weight(){
		double allWeight = 0.00;
		Iterator it = mst.iterator();
		while(it.hasNext()){
			Edge e = (Edge) it.next();
			allWeight += e.weight();
			System.out.println(e.either()+"→"+e.other(e.either()));
		}
		return allWeight;
	}
}
