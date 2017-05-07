package com.example.graph;

public class GraphTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph gh = new Graph(6).initGraph(7);
		//System.out.println(GraphHandler.avgDegree(gh));
		//System.out.println(gh.toString());
		DepthFirstSearch dfs = new DepthFirstSearch(gh,0);
	}

}
