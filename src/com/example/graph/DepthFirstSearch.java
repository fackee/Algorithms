package com.example.graph;

import java.util.Stack;

public class DepthFirstSearch {
	private boolean marked[];
	private int[] edgeTo;
	private int s;
	private int count = 0;
	
	public DepthFirstSearch(Graph G,int s){
		marked = new boolean[G.getVertex()];
		this.s = s;
		edgeTo = new int[G.getVertex()];
		dfs(G,s);
	}
	
	public DepthFirstSearch(Graph g,Iterable<Integer> source){
		marked = new boolean[g.getVertex()];
		for(int w : source){
			dfs(g,w);
		}
	}
	
	private void dfs(Graph<Integer> G,int v){
		marked[v] = true;
		count++; 
		for(int w : G.adj(v)){
			if(!marked[w]){
				edgeTo[w] = v;
				dfs(G,w);
			}
		}
	}
	
	public boolean hashPathTo(int w){
		return marked[w];
	}
	
	public int count(){
		return count;
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hashPathTo(v)){
			return null;
		}
		Stack<Integer> stack = new Stack<>();
		for(int x = v;x != s; x = edgeTo[x]){
			stack.push(x);
		}
		stack.push(s);
		return stack;
	}
	
}
