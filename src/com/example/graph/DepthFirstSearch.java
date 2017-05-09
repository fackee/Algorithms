package com.example.graph;

public class DepthFirstSearch {
	private boolean marked[];
	private int count = 0;
	
	public DepthFirstSearch(Graph G,int s){
		marked = new boolean[G.getVertex()];
		dfs(G,s);
	}
	
	private void dfs(Graph G,int s){
		marked[s] = true;
		count++;
		for(int w : G.adj(s)){
			if(!marked[w]){
				System.out.print(w+"¡ú");
				dfs(G,w);
			}
		}
	}
	
	public boolean marked(int w){
		return marked[w];
	}
	
	public int count(){
		return count;
	}
}
