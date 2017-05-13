package com.example.graph;

import java.util.Stack;

public class DirectedCycle {
	
	private boolean[] marked;
	private int[] edgeTo;
	private Stack<Integer> cycle;
	private boolean[] onStack;

	public DirectedCycle(Digraph G){
		onStack = new boolean[G.getVertex()];
		marked = new boolean[G.getVertex()];
		edgeTo = new int[G.getVertex()];
		for(int v=0;v<G.getVertex();v++){
			if(!marked[v]){
				dfs(G,v);
			}
		}
	}
	
	private void dfs(Digraph g,int v){
		onStack[v] = true;
		marked[v] = true;
		for(int w : g.adj(v)){
			if(hasCycle()){
				return;
			}else if(!marked[w]){
				edgeTo[w] = v;
				dfs(g,w);
			}else if(onStack[w]){
				cycle = new Stack<>();
				for(int x = v;x != w;x = edgeTo[x]){
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(v);
			}
		}
		onStack[v] = false;
	}
	
	public boolean hasCycle(){
		return cycle != null;
	}
	
	public Iterable<Integer> cycle(){
		return cycle;
	}
	
}
