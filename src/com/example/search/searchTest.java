package com.example.search;

import java.util.Iterator;
import java.util.Queue;

public class searchTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST bst = new BST();
		BST bbst = new BST();
		RedBlackBST rb = new RedBlackBST();
		rb.put(10, 10);
		rb.put(7, 7);
		rb.put(12, 12);
		rb.put(14, 14);
		rb.put(5, 5);
		rb.put(8, 8);
		rb.iterator();
		//System.out.println(rb.size());
		/*bst.put(6, "f");
		bst.put(5, "g");
		bst.put(7, "c");
		bst.put(1, "b");
		bst.put(3, "d");
		Iterator<Integer> it = bst.keys(3,7);
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
		System.out.println(bst.get(6));*/
	}

}
