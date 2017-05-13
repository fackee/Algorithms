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
			System.out.print(it.next()+"鈫�");
		}
		CC cc = new CC(gh);*/
		Graph g = new Digraph(3).init(3);
		//BreathFirstSearch fs = new BreathFirstSearch(g,0);
		//DepthFirstSearch dfs = new DepthFirstSearch(g,0);
		//DirectBFS bfs = new DirectBFS(dg,0);
		//Iterator it = dfs.pathTo(3).iterator();
		//while(it.hasNext()){
		//	System.out.print(it.next()+"鈫�");
		//}
		//System.out.print("\n");
		Iterator it = new DirectedCycle((Digraph)g).cycle().iterator();
		while(it.hasNext()){
			System.out.print(it.next()+"←");
		}
	}
}
