package com.example.graph;

public class CC {
	
	private boolean[] marked;
	private int[] id;
	private int count = 0;
	
	public CC(Graph G){
		marked = new boolean[G.getVertex()];
		id = new int[G.getVertex()];
		for(int s = 0; s < G.getVertex();s++){
			if(!marked[s]){
				count++;
				dfs(G,s);
			}
			System.out.print("id-"+s+":"+id[s]);
		}
	}
	
	private void dfs(Graph G,int v){
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj(v)){
			if(!marked[w]){
				dfs(G,w);
			}
		}
	}
	
	public boolean connected(int v,int w){
		return id[v] == id[w];
	}
	
	public int id(int v){
		return id[v];
	}
	
	public int count(){
		return count;
	}
	
}
