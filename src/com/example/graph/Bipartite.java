package com.example.graph;

public class Bipartite {
	
	private boolean[] marked;
	private boolean[] color;
	private boolean isBipartite = true;
	
	public Bipartite(Graph G){
		marked = new boolean[G.getVertex()];
		color = new boolean[G.getVertex()];
	}
	
	private void dfs(Graph G,int v){
		marked[v] = true;
		for(int w : G.adj(v)){
			if(!marked[w]){
				color[w] = !color[v];
				dfs(G,w);
			}else if(color[w] == color[v]){
				isBipartite = false;
			}
		}
	}
	
	public boolean isBipartite(){
		return isBipartite;
	}
}
