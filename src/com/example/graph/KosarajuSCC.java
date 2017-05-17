package com.example.graph;

public class KosarajuSCC {

	private boolean[] marked;
	private int[] id;
	private int count;
	
	public KosarajuSCC(Digraph g){
		marked = new boolean[g.getVertex()];
		id = new int[g.getVertex()];
		DepthFirstOrder dfo = new DepthFirstOrder(g.reverse());
		for(int s : dfo.reservePost()){
			if(!marked[s]){
				dfs(g,s);
				count++;
			}
		}
	}
	
	private void dfs(Digraph g,int v){
		marked[v] = true;
		id[v] = count;
		for(int w : g.adj(v)){
			if(!marked[w]){
				dfs(g,w);
			}
		}
	}
	
	public boolean stronglyConnected(int v,int w){
		return id[v] == id[w];
	}
	
	public int count(){
		return count;
	}
	
}
