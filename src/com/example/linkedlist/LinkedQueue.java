package com.example.linkedlist;


public class LinkedQueue<Item>{
	private Node head;
	private Node first;
	private int N = 0;
	private class Node {
		Item item;
		Node next;
	}
	public boolean isEmpty(){
		return head == null;
	}
	public int size(){
		return N;
	}
	public void enqueue(Item item){
		Node temp = new Node();
		temp.item = item;
		if(first == null){
			first = temp;
			head = first;
			return;
		}
		first.next = temp;
		first = first.next;
		N++;
	}
	public Item dequeue(){
		Item item = head.item;
		head = head.next;
		N--;
		return item;
	}

}
