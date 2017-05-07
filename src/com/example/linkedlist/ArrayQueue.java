package com.example.linkedlist;

import java.util.Iterator;

public class ArrayQueue<Item> implements Iterable<Item>{

	private Item queue[] = (Item[]) new Object[20];
	private int N = 0;
	public boolean isEmpty(){
		return N == 0;
	}
	public int size(){
		return N;
	} 
	private void resize(int max){
		Item[] temp = (Item[])new Object[max];
		for(int i=0;i<N;i++){
			temp[i] = queue[i];
		}
		queue = temp;
	}
	public void enqueue(Item item){
		queue[N++] = item;
		if(N > 0 && N == queue.length){
			resize(queue.length*2);
		}
	}
	public Item dequeue(){
		Item item = queue[0];
		for(int i=0;i<N;i++){
			queue[i] = queue[i+1];
		}
		queue[N--] = null;//避免对象游离
		if(N <= queue.length/4){
			resize(queue.length/2);
		}
		return item;
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ArrayQueueIterator();
	}
	private class ArrayQueueIterator implements Iterator{

		@Override
		public boolean hasNext() {
			
			return N != 0;
		}

		@Override
		public Object next() {
			Item item = queue[0];
			for(int i=0;i<N;i++){
				queue[i] = queue[i+1];
			}
			queue[N--] = null;//避免对象游离
			if(N <= queue.length/4){
				resize(queue.length/2);
			}
			return item;
		}
		
	}
}
