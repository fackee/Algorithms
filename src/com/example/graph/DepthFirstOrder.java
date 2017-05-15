package com.example.graph;

import java.util.Stack;

import com.example.linkedlist.LinkedQueue;

public class DepthFirstOrder {

	private LinkedQueue<Integer> pre;
	private LinkedQueue<Integer> post;
	private Stack<Integer> reservePost;
	private boolean[] marked;
	
	public DepthFirstOrder(Digraph g){
		pre = new LinkedQueue<>();
		post = new LinkedQueue<>();
		reservePost = new Stack<>();
		marked = new boolean[g.getVertex()];
		
		for(int v=0;v<g.getVertex();v++){
			if(!marked[v]){
				dfs(g,v);
			}
		}
	}
	
	private void dfs(Digraph g,int v){
		pre.enqueue(v);
		marked[v] = true;
		for(int w: g.adj(v)){
			if(!marked[w]){
				dfs(g,w);
			}
		}
		post.enqueue(v);
		reservePost.push(v);
	}
	
	public Iterable<Integer> pre(){
		return pre;
	}
	public Iterable<Integer> post(){
		return post;
	}
	public Iterable<Integer> reservePost(){
		return reservePost;
	}
}
