package com.example.graph;

public interface Graph {
	
	//初始化图
	public Graph init(int Edge);
	//添加变
	public void addEdge(int v,int w);
	//获取顶点
	public int getVertex();
	//获取边
	public int getEdge();
	//获取邻接表
	public Iterable<Integer> adj(int v);
	//toString方法
	public String toString();
}
