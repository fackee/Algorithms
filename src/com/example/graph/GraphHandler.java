package com.example.graph;

import java.util.Iterator;

public class GraphHandler {
	public static int degree(Undigraph G,int v){
		int count = 0;
		Iterator it = G.adj(v).iterator();
		while(it.hasNext()){
			count++;
		}
		return count;
	}
	public static int maxDegree(Undigraph G){
		int max = 0;
		for(int v=0;v<G.getVertex();v++){
			if(degree(G,v) > max){
				max = degree(G,v);
			}
		}
		return max;
	}
	public static double avgDegree(Undigraph G){
		return G.getEdge()/G.getVertex();
	}
	public static int numberOfSelfLoops(Undigraph G){
		int count = 0;
		for(int v=0;v<G.getVertex();v++){
			for(int w : G.adj(v)){
				if(w == v){
					count ++;
				}
			}
		}
		return count;
	}
}
