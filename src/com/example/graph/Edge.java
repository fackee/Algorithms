package com.example.graph;

import java.util.Scanner;

public class Edge implements Comparable<Edge>{

	private final int v;
	private final int w;
	private final double weight;
	
	public Edge(){
		Scanner sc = new Scanner(System.in);
		this.v= sc.nextInt();
		this.w= sc.nextInt();
		this.weight = sc.nextDouble();
	}
	
	public double weight(){
		return weight;
	}
	
	public int either(){
		return v;
	}
	public int other(int vertex){
		if(vertex == v) return w;
		else if(vertex == w) return v;
		else throw new RuntimeException("Inconsistant Edge");
	}
	/*public String toString(){
		return String.format("%d-%d %0.2f", v,w,weight);
	}*/
	
	@Override
	public int compareTo(Edge that) {
		if(this.weight > that.weight) return 1;
		else if(this.weight < that.weight) return -1;
		else return 0;
	}
	

}
