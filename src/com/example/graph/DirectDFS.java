package com.example.graph;

import java.util.Stack;

public class DirectDFS {
	
	private boolean[] marked;
	private int count = 0;
	private int[] edgeTo;
	private int s;
	
	public DirectDFS(Digraph dg,int s){
		marked = new boolean[dg.Edge()];
		edgeTo = new int[dg.Edge()];
		dfs(dg,s);
		this.s = s;
	}
	
	public DirectDFS(Digraph dg,Iterable<Integer> source){
		marked = new boolean[dg.Edge()];
		for(int w : source){
			dfs(dg,w);
		}
	}
	
	private void dfs(Digraph dg,int v){
		marked[v] = true;
		for(int w : dg.adj(v)){
			if(!marked[w]){
				edgeTo[w] = v;
				dfs(dg,w);
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
