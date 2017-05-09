package com.example.graph;

public class GraphTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph gh = new Graph(4).initGraph(5);
		//System.out.println(GraphHandler.avgDegree(gh));
		//System.out.println(gh.toString());
		DepthFirstSearch dfs = new DepthFirstSearch(gh,1);
	}

}
