package com.example.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

public class DoublyLinked<Item> implements Iterator{
	
	private class Node{
		private Item item;
		private Node next;
		private Node previous;
	}
	private Node head;
	private Node tail;
	private int N = 0;
	
	public boolean isEmpty(){
		return N == 0;
	}
	public int size(){
		return N;
	}
	
	public void insertNodeAtNext(Item item){
		Node node = new Node();
		node.item = item;
		if(head == null){
			head = node;
		}else{
			tail.next = node;
			node.previous = tail;
		}
		tail = node;
		N++;
		
	}
	public void insertAtPrevious(Item item){
		Node node = new Node();
		node.item = item;
		if(head == null){
			tail = node;
		}else{
			head.previous = node;
			node.next = head;
		}
		head = node;
		N++;
	}
	public boolean hasPrevious(){
		return tail != null;
	}
	@Override
	public boolean hasNext() {
		return head != null;
	}
	@Override
	public Item next() {
		Item item = head.item;
		head = head.next;
		return item;
	}
	public Item previous(){
		Item item = tail.item;
		tail = tail.previous;
		return item;
	}
	
}
