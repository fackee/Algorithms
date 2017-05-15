package com.example.linkedlist;

import java.util.Iterator;

public class LinkedQueue<Item> implements Iterable{
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
		if(head == first){
			head = null;
			first = null;
		}else{
			head = head.next;
			N--;
		}
		N--;
		return item;
	}
	@Override
	public Iterator iterator() {
		
		return new QueueIterator();
	}
	private class QueueIterator implements Iterator{

		@Override
		public boolean hasNext() {
			return head!=null;
		}

		@Override
		public Object next() {
			Item item = head.item;
			head = head.next;
			return item;
		}
		
	}

}
