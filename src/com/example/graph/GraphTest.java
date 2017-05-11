package com.example.graph;

import java.util.Iterator;

public class GraphTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Graph gh = new Graph(13).initGraph(13);
		//System.out.println(GraphHandler.avgDegree(gh));
		BreathFirstSearch bfs = new BreathFirstSearch(gh, 0);
		Iterator<Integer> it = bfs.pathTo(3).iterator();
		while(it.hasNext()){
			System.out.print(it.next()+"¡ú");
		}
		CC cc = new CC(gh);*/
		Digraph dg = new Digraph(4).init(5);
		System.out.print(dg.toString());
	}
}
