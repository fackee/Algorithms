package com.example.graph;

public class GraphTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Graph gh = new Graph(13).initGraph(13);
		System.out.println(GraphHandler.avgDegree(gh));
		BreathFirstSearch bfs = new BreathFirstSearch(gh, 0);
		Iterator<Integer> it = bfs.pathTo(3).iterator();
		while(it.hasNext()){
			System.out.print(it.next()+"鈫�");
		}
		CC cc = new CC(gh);
		Graph g = new Digraph(3).init(3);
		BreathFirstSearch fs = new BreathFirstSearch(g,0);
		DepthFirstSearch dfs = new DepthFirstSearch(g,0);
		DirectBFS bfs = new DirectBFS(dg,0);
		Iterator it = dfs.pathTo(3).iterator();
		while(it.hasNext()){
			System.out.print(it.next()+"鈫�");
		}
		System.out.print("\n");
		Iterator it = new DepthFirstOrder((Digraph)g).reservePost().iterator();
		while(it.hasNext()){
			System.out.print(it.next()+"←");
		}*/
		
		EdgeWeightedGraph ewg = new EdgeWeightedGraph(8).init(16);
		/*Iterator it = ewg.adj().iterator();
		while(it.hasNext()){
			Edge e = (Edge) it.next();
			System.out.println(e.either()+","+e.other(e.either())+","+e.weight());
		}*/
		//new PrimMST(ewg).showPath();
		//System.out.print(new PrimMST(ewg).weight());
		KruskalMST km = new KruskalMST(ewg);
		System.out.print(km.minWeight());
	}
}
/*0 7 0.16
0 2 0.26
0 4 0.38
0 6 0.58
1 7 0.19
5 7 0.28
2 7 0.34
4 7 0.37
1 3 0.29
1 5 0.32
1 2 0.36
2 3 0.17
6 2 0.10
3 6 0.52
4 5 0.35
6 4 0.93*/