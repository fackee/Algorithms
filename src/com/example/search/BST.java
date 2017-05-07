package com.example.search;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>,Value> {
	
	private Node root;
	private class Node{
		private Key key;
		private Value value;
		private Node left,right;
		private int N;
		Node(Key key,Value value,int N){
			this.key = key;
			this.value = value;
			this.N = N;
		}
	}
	
	public int size(){
		return size(root);
	}
	private int size(Node node){
		if(node == null){
			return 0;
		}else{
			return node.N;
		}
	}
	
	public Value get(Key key){
		return get(root,key);
	}
	private Value get(Node node,Key key){
		if(node == null){
			return null;
		}
		int compare = key.compareTo(node.key);
		if(compare > 0){
			return get(node.right,key);
		}else if(compare < 0){
			return get(node.left,key);
		}else{
			return node.value;
		}
	}
	
	public void put(Key key,Value value){
		root = put(root,key,value);
	}
	private Node put(Node node,Key key,Value value){
		if(node == null){
			return new Node(key,value,1);
		}
		int compare = key.compareTo(node.key);
		if(compare <0){
			node.left = put(node.left,key,value);
		}else if(compare >0){
			node.right = put(node.right,key,value);
		}else{
			node.value = value;
		}
		node.N = size(node.left) + size(node.right);
		return node;
	}
	public Key Min(){
		return Min(root).key;
	}
	private Node Min(Node node){
		if(node.left == null){
			return node;
		}
		return Min(node.left);
	}
	
	public Key Max(){
		return Max(root).key;
	}
	private Node Max(Node node){
		if(node.right == null){
			return node;
		}
		return Max(node.right);
	}
	
	public void deleteMin(){
		root = deleteMin(root);
	}
	private Node deleteMin(Node node){
		if(node.left == null){
			return node.right;
		}
		node.left = deleteMin(node.left);
		node.N = size(node.left) + size(node.right) + 1;
		return node;
	}
	
	public void delete(Key key){
		root = delete(root,key);
	}
	private Node delete(Node node,Key key){
		if(node == null){
			return null;
		}
		int compare = key.compareTo(node.key);
		if(compare < 0){
			node.left = delete(node.left,key);
		}else if(compare > 0){
			node.right = delete(node.right,key);
		}else{
			if(node.right == null){
				
			}
			if(node.left == null){
				
			}
			Node t = node;
			node = Min(t.right);
			node.right = deleteMin(t.right);
			node.left = t.left;
		}
		node.N = size(node.left) + size(node.right) + 1;
		return node;
	}
	public void iterator(){
		iterator(root);
	}
	private void iterator(Node node){
		if(node == null){
			return;
		}
		iterator(node.left);
		System.out.println("Key:"+node.key+","+"Value:"+node.value);
		iterator(node.right);
	}
	
	public Iterator<Key> keys(){
		return keys(Min(),Max());
	}
	public Iterator<Key> keys(Key low,Key high){
		Queue<Key> queue = new LinkedList<Key>();
		keys(root,queue,low,high);
		return queue.iterator();
		
	}
	private void keys(Node node,Queue<Key> queue,Key low,Key high){
		if(node == null){
			return;
		}
		int compareLow = low.compareTo(node.key);
		int compareHigh = high.compareTo(node.key);
		if(compareLow < 0 ){
			keys(node.left,queue,low,high);
		}
		if(compareLow < 0 && compareHigh >0){
			queue.add(node.key);
		}
		if(compareHigh > 0){
			keys(node.right,queue,low,high);
		}
		
	}
 
}
