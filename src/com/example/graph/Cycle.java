package com.example.graph;

public class Cycle {
	
	private boolean[] marked;
	private boolean hasCycle;
	
	public Cycle(Undigraph G){
		marked = new boolean[G.getVertex()];
		for(int s = 0;s < G.getVertex();s++){
			if(!marked[s]){
				dfs(G,s,s);
			}
		}
	}
	
	private void dfs(Undigraph G,int v,int u){
		marked[v] = true;
		for(int w : G.adj(v)){
			if(!marked[w]){
				dfs(G,w,v);
			}else if(w != u){
				hasCycle = true;
			}
		}
	}
	
	public boolean hasCycle(){
		return hasCycle;
	}
	
	
}
