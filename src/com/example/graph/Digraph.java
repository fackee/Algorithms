package com.example.graph;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Digraph implements Graph{
	
	private final int Vertext;
	private int Edge;
	private Set<Integer>[] adj;
	public Digraph(int Vertext){
		this.Vertext = Vertext;
		adj = new HashSet[Vertext];
		for(int i=0;i<Vertext;i++){
			adj[i] = new HashSet<>();
		}
	}
	@Override
	public Graph init(int Edge){
		this.Edge = Edge;
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<Edge;i++){
			int v = sc.nextInt();
			int w = sc.nextInt();
			adj[v].add(w);
		}
		return this;
	}
	
	@Override
	public int getVertex(){
		return Vertext;
	}
	
	@Override
	public int getEdge(){
		return Edge;
	}
	
	@Override
	public void addEdge(int v,int w){
		Edge++;
		adj[v].add(w);
	}
	
	@Override
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public Digraph reverse(){
		Digraph R = new Digraph(Vertext);
		for(int v=0;v<Vertext;v++){
			for(int w : adj[v]){
				R.addEdge(w, v);
			}
		}
		return R;
	}
	@Override
	public String toString(){
		String graph= "";
		for(int v=0;v<Vertext;v++){
			graph += v;
			for(int w : adj[v]){
				graph += "��"+w;
			}
			graph += "\n";
		}
		return graph;
	}

}
