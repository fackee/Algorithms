package com.example.search;

public class RedBlackBST<Key extends Comparable<Key>,Value> {
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private Node root;
	private class Node{
		private Key key;
		private Value value;
		private Node left,right;
		private int N;
		private boolean color;
		Node(Key key,Value value,int N,boolean color){
			this.key = key;
			this.value = value;
			this.N = N;
			this.color = color;
		}
	}
	private boolean isRed(Node node){
		if(node == null){
			return false;
		}
		return node.color == RED;
	}
	private Node rotateLeft(Node node){
		Node temp = node.right;
		node.right = temp.left;
		temp.left = node;
		temp.color = node.color;
		node.color = RED;
		temp.N = node.N;
		node.N = size(node.left) + size(node.right) + 1;
		return temp;
	}
	private Node rotateRight(Node node){
		Node temp = node.left;
		node.left = temp.right;
		temp.right = node;
		temp.color = node.color;
		node.color = RED;
		temp.N = node.N;
		node.N = size(node.left) + size(node.right) + 1;
		return temp;
	}
	private void flipColors(Node node){
		node.color = RED;
		node.left.color = BLACK;
		node.right.color = BLACK;
	}
	public int size(){
		return size(root);
	}
	private int size(Node node){
		if(node == null){
			return 0;
		}
		return node.N;
	}
	public Value get(Key key){
		return get(root,key);
	}
	private Value get(Node node,Key key){
		if(node == null){
			return null;
		}
		int compare = key.compareTo(node.key);
		if(compare < 0){
			return get(node.left,key);
		}else if(compare > 0){
			return get(node.right,key);
		}else{
			return node.value;
		}
	}
	public void put(Key key,Value value){
		root = put(root,key,value);
		root.color = BLACK;
	}
	private Node put(Node node,Key key,Value value){
		if(node == null){
			return new Node(key,value,1,RED);
		}
		int compare = key.compareTo(node.key);
		if(compare < 0){
			node.left = put(node.left,key,value);
		}else if(compare > 0){
			node.right = put(node.right,key,value);
		}else{
			node.value = value;
		}
		if(isRed(node.right) && !isRed(node.left)){
			node = rotateLeft(node);
		}
		if(isRed(node.left) && !isRed(node.right)){
			node = rotateRight(node);
		}
		if(isRed(node.left) && isRed(node.right)){
			flipColors(node);
		}
		node.N = size(node.left) + size(node.right) +1;
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
		System.out.println("Key:"+node.key+","+"value:"+node.value);
		iterator(node.right);
	}
}
