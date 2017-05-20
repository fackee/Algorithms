package com.example.graph;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Undigraph implements Graph<Integer>{
	private int Vertex;
	private int Edge = 0;
	private Set<Integer>[] adj;
	public Undigraph(int Vertex){
		this.Vertex = Vertex;
		adj = new HashSet[Vertex];
		for(int v=0;v<Vertex;v++){
			adj[v] = new HashSet<Integer>();
		}
	}
	
	@Override
	public Graph init(int Edge) {
		this.Edge = Edge;
		Scanner sc = new Scanner(System.in);
		for(int e=0;e<Edge;e++){
			int v = sc.nextInt();
			int w = sc.nextInt();
			addEdge(v,w);
		}
		return this;
	}
	@Override
	public void addEdge(int v,int w){
		adj[v].add(w);
		adj[w].add(v);
		Edge++;
	}
	@Override
	public int getVertex(){
		return Vertex;
	}
	@Override
	public int getEdge(){
		return Edge;
	}
	@Override
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	@Override
	public String toString(){
		String str = Vertex + "vertexs"+"and"+Edge+"edges\n";
		for(int v=0;v<Vertex;v++){
			str += v+"→";
			for(int w : adj[v]){
				str += w+"→";
			}
			str += "\n";
		}
		return str;
	}
}
