package com.example.search;

public class BalanceST<Key extends Comparable<Key>,Value> {
	private Node root;
	private class Node{
		private Node left,middle,right;
		private int N;
		private Key key;
		private Key bKey;
		private Value value;
		private Value bValue;
		private Key backKey;
		private Value backValue;
		private int type;
		public Node(Key key,Value value,int N){
			this.key = key;
			this.value = value;
			this.N = N;
			this.type = 2;
		}
		public Node(Key key,Value value,Key bKey,Value bValue,int N){
			this.key = key;
			this.bKey = bKey;
			this.value = value;
			this.bValue = bValue;
			this.N = N;
			this.type = 3;
		}
		public Node(Key key,Value value,Key bKey,Value bValue,Key backKey,Value backValue,int N){
			this.key = key;
			this.bKey = bKey;
			this.value = value;
			this.bValue = bValue;
			this.backKey = backKey;
			this.backValue = backValue;
			this.N = N;
			this.type = 4;
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
		if(node.type == 2){
			int compare = key.compareTo(node.key);
			if(compare >0){
				return get(node.right,key);
			}else if(compare < 0){
				return get(node.left,key);
			}else{
				return node.value;
			}
		}else{
			int lcompare = key.compareTo(node.key);
			int rcompare = key.compareTo(node.bKey);
			if(lcompare < 0 ){
				return get(node.left,key);
			}else if(lcompare == 0){
				return node.value;
			}else{
				if(rcompare > 0 ){
					return get(node.right,key);
				}else if(rcompare == 0){
					return node.bValue;
				}else{
					return get(node.middle,key);
				}
			}
		}
	}
	
	public void put(Key key,Value value){
		root = put(root,key,value);
	}
	public void put(Key key,Value value,Key bkey,Value bvalue){
		
		
	}
	private Node put(Node node,Key key,Value value){
		if(node == null){
			return new Node(key,value,1);
		}
		if(node.type == 2){
			int compare = key.compareTo(key);
			if(compare < 0){
				node.left = put(node.left,key,value);
			}else if(compare > 0){
				node.right = put(node.right,key,value);
			}else{
				node.value = value;
			}
		}else if(node.type == 3){
			int compare = key.compareTo(node.key);
			int bcompare = key.compareTo(node.bKey);
			if(compare < 0){
				
			}
		}
		node.N = size(node.left) + size(node.right) + size(node.middle);
		return node;
	}
	private Node put(Node node,Key key,Value value,Key bkey,Value bvalue){
		node.N = size(node.left) + size(node.right) + size(node.middle);
		return node;
	}
}
