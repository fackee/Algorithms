package com.example.graph;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Graph {
	private int Vertex;
	private int Edge;
	private int count = 0;
	private Set<Integer>[] adj;
	public Graph(int Vertex){
		this.Vertex = Vertex;
		adj = new HashSet[Vertex];
		for(int v=0;v<Vertex;v++){
			adj[v] = new HashSet<Integer>();
		}
	}
	
	public Graph initGraph(int Edge){
		this.Edge = Edge;
		Scanner sc = new Scanner(System.in);
		for(int e=0;e<Edge;e++){
			int v = sc.nextInt();
			int w = sc.nextInt();
			addEdge(v,w);
		}
		return this;
	}
	
	public void addEdge(int v,int w){
		adj[v].add(w);
		adj[w].add(v);
		count++;
	}
	public int getVertex(){
		return Vertex;
	}
	public int getEdge(){
		return Edge;
	}
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public String toString(){
		String str = Vertex + "vertexs"+"and"+Edge+"edges\n";
		for(int v=0;v<Vertex;v++){
			str += v+"¡ª";
			for(int w : adj[v]){
				str += w+"¡ª";
			}
			str += "\n";
		}
		return str;
	}
}
