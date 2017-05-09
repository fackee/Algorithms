package com.example.graph;

import java.util.Queue;
import java.util.Stack;

import com.example.linkedlist.ArrayQueue;
import com.example.linkedlist.LinkedQueue;

public class BreathFirstSearch {

	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	
	public BreathFirstSearch(Graph G,int s){
		marked = new boolean[G.getVertex()];
		edgeTo = new int[G.getVertex()];
		this.s = s;
		bfs(G,s);
	}
	
	private void bfs(Graph G,int s){
		ArrayQueue<Integer> queue = new ArrayQueue<>();
		marked[s] = true;
		queue.enqueue(s);
		while(!queue.isEmpty()){
			int v = queue.dequeue();
			for(int w : G.adj(v)){
				if(!marked[w]){
					edgeTo[w] = v;
					marked[w] = true;
					queue.enqueue(w);
				}
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)){
			return null;
		}
		Stack<Integer> stack = new Stack<>();
		for(int x = v; x != s; x = edgeTo[x]){
			stack.push(x);
		}
		stack.push(s);
		return stack;
	}
	
	
}
