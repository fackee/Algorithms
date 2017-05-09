package com.example.graph;

import java.util.Iterator;

public class GraphTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph gh = new Graph(6).initGraph(8);
		//System.out.println(GraphHandler.avgDegree(gh));
		BreathFirstSearch bfs = new BreathFirstSearch(gh, 0);
		Iterator<Integer> it = bfs.pathTo(3).iterator();
		while(it.hasNext()){
			System.out.print(it.next()+"¡ú");
		}
	}

}
