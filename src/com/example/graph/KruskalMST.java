package com.example.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.example.linkedlist.LinkedQueue;

public class KruskalMST {

	private LinkedQueue<Edge> mst;
	
	public KruskalMST(EdgeWeightedGraph G){
		mst = new LinkedQueue<Edge>();
		List<Edge> pq = (List<Edge>) G.edges();
		List<Edge> temp = new LinkedList<Edge>();
		for(Edge e : pq){
			temp.add(e);
			Undigraph isCycle = (Undigraph) new Undigraph(G.getVertex()).init(temp);
			if(new Cycle(isCycle).hasCycle()){
				temp.remove(e);
			}else{
				System.out.println("Enqueue:"+e.either()+","+e.other(e.either())+","+e.weight());
				mst.enqueue(e);
			}
		}
	}
	
	public double minWeight(){
		double weightSum = 0;
		Iterator it = mst.iterator();
		while(it.hasNext()){
			Edge e = (Edge)it.next();
			weightSum += e.weight();
		}
		return weightSum;
	}
	
}
