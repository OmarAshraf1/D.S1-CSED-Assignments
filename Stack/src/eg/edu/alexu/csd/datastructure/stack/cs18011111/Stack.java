package eg.edu.alexu.csd.datastructure.stack.cs18011111;

import eg.edu.alexu.csd.datastructure.stack.IStack;  

/**
 * 
 * @author Omar
 *
 */

public class Stack implements IStack {

	Node head ;
	int size = 0 ;
	static class Node {
		Object data ;
		Node next ;
		Node(Object d){
			this.data = d ;
		}
		
}	
	@Override
	public Object pop() {
		if(isEmpty()) {
			 throw new RuntimeException(); 
		}
		else {
		Node temp = head ;
		head = temp.next ;
		temp.next = null ;
		size -- ;
		return temp.data ;
		}
	}
	@Override
	public Object peek() {
		if(isEmpty()) {
			 throw new RuntimeException();
		}
		else {
			return head.data ;
		}
	}
	@Override
	public void push(Object element) {
		Node newnode = new Node(element) ;
		if(isEmpty()) {
			 head = newnode ;
			 size ++ ;
		}
		else {
		Node temp = head ;
		head = newnode ;
		newnode.next = temp ;
		size ++ ;
		}
	}
	@Override
	public boolean isEmpty() {
		if(size == 0 ) {
			return true ;
		}
		else {
			return false ;
		}
		
	}
	@Override
	public int size() {
		
		return size ;
	
	}
	/**
	 * to print stack to be used in stack UI
	 * 
	 */
	public void print() {
		Node temp = head ;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next ;
		}
	}
}