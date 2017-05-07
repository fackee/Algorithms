package com.example.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

public class LinkedList<Item> implements Iterator{
	private Node first;
	private Node end;
	private int N = 0;
	private class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty(){
		return first == null;
	}
	public int size(){
		return N;
	}
	//在表头插入节点
	public void insertNodeInHead(Item item){
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		if(oldfirst == null){
			end = first;
		}
		N++;
	}
	//在表尾插入节点
	public void insertNodeInEnd(Item item){
		Node oldend = end;
		end = new Node();
		end.item = item;
		oldend.next = end;
		N++;
	}
	//在任意位置插入节点
	public void insertAtIndex(int index,Item item){
		Node idx = first;
		for(int i=0;i<index-1;i++){
			idx = idx.next;
		}
		Node temp = new Node();
		temp.item = item;
		temp.next = idx.next;
		idx.next = temp;
	}
	@Override
	public boolean hasNext() {
		return first != null;
	}
	@Override
	public Item next() {
		Item item = first.item;
		first = first.next;
		return item;
	}
	
}
