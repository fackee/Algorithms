package com.example.linkedlist;

import java.util.Iterator;

public class ArrayStack<Item> implements Iterable<Item>{
	private Item stack[] = (Item[])new Object[20];
	private int N = 0;
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	private void resize(int max){
		Item temp[] = (Item[])new Object[max];
		for(int i=0;i<N;i++){
			temp[i] = stack[i];
		}
		stack = temp;
	}
	public void push(Item item){
		if(N == stack.length){
			resize(2*stack.length);
		}
		stack[N++] = item;
	}
	public Item pop(){
		Item item = stack[N--];
		stack[N] = null;//避免对象游离
		if(N >0 && N == stack.length/4){
			resize(stack.length/2);
		}
		return item;
	}
	@Override
	public Iterator<Item> iterator() {
		return new ArrayStackIterator();
	}
	private class ArrayStackIterator implements Iterator<Item>{
		private int index = N;
		@Override
		public boolean hasNext() {
			return index > 0;
		}

		@Override
		public Item next() {
			return stack[--index];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
