package com.example.linkedlist;

public class LinkedListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Stack<String> s = new Stack<String>();
		//s.push("to");s.push("be");s.push("or");s.push("not");
		//System.out.println(s.size());
		//LinkedList<String> ll = new LinkedList();
		//ll.insertNodeInHead("t");ll.insertNodeInHead("e");ll.insertNodeInHead("s");
		//ll.insertNodeInEnd("a");ll.insertNodeInEnd("B");
		//ll.insertAtIndex(2,"X");
		//while(ll.hasNext()){
		//	System.out.println(ll.next());
		//}
		/*DoublyLinked<String> dl = new DoublyLinked();
		dl.insertAtPrevious("2");
		dl.insertAtPrevious("1");
		dl.insertNodeAtNext("3");
		dl.insertNodeAtNext("4");
		dl.insertNodeAtNext("5");
		dl.insertNodeAtNext("6");
		System.out.println("size:"+dl.size());
		while(dl.hasPrevious()){
			System.out.println(dl.previous());
		}*/
		LinkedQueue<Integer> queue = new LinkedQueue<>();
		queue.enqueue(0);
		queue.dequeue();
		queue.enqueue(2);
		queue.enqueue(1);
		queue.enqueue(5);
		queue.dequeue();
		queue.enqueue(3);
		queue.enqueue(4);
		while(!queue.isEmpty()){
			System.out.print(queue.dequeue());
		}
	}

}
