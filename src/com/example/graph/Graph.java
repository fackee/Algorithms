package com.example.graph;

public interface Graph <Type>{
	
	//初始化图
	public Graph init(int Edge);
	//添加加权边
	public default void addEdge(int v,int w){
		
	};
	//添加变
	public default void addEdge(Type type){
		
	};
	//获取顶点
	public int getVertex();
	//获取边
	public int getEdge();
	//获取邻接表
	public Iterable<Type> adj(int v);
	//toString方法
	public String toString();
}
