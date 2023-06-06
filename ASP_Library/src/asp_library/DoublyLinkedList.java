package asp_library;

import Exceptions.StructureEmptyException;

public class DoublyLinkedList {
	private class Node{
		public Node(int number) {
			this.number = number;
			next = prev = null;
		}
		private int number;
		private Node next;
		private Node prev;
	}
	private Node head;
	private Node tail;
	private String name;
	
	// Constructor without initializing the name of the list 
	public DoublyLinkedList() {
		this.name = new String("");
		head = tail = null;
	}
	
	// Constructor with initializing the name of the list
	public DoublyLinkedList(String name) {
		this.name = name;
		head = tail = null;
	}
	
	// Getter for the name of the list
	public String getName() {return this.name;}
	
	// Setter for the name of the list
	public void setName(String newName) {this.name = newName;}
	
	// Inserting an element at the start of the list
	public void insertStart(int number) {
		if(head == null) head = new Node(number);
		if(tail == null) {
			Node tmp = new Node(number);
			tmp.next = head;
			head.prev = tmp;
			head = head.prev;
			tail = head.next;
		}
		else {
			Node tmp = new Node(number);
			tmp.next = head;
			head.prev = tmp;
			head = head.prev;
		}
	}
	
	// Inserting an element at the end of the list
	public void insertEnd(int number) {
		if(head == null) head = new Node(number);
		if(tail == null) {
			tail = new Node(number);
			tail.prev = head;
			head.next = tail;
		}
		else {
			tail.next = new Node(number);
			tail.next.prev = tail;
			tail = tail.next;
		}
		
	}
	
	// Removing an element from the start of the list
	public int removeStart() throws StructureEmptyException {
		if(head == null) throw new StructureEmptyException("Doubly linked list is empty");
		int x = head.number;
		head = head.next;
		head.prev = null;
		return x;
	}
	
	// Removing an element from the end of the list
	public int removeEnd() throws StructureEmptyException {
		if(head == null) throw new StructureEmptyException("Doubly linked list is empty");
		int x = tail.number;
		tail = tail.prev;
		tail.next = null;
		return x;
	}
	
	// Inserting at the i-th place in the list
	public void insertIndex(int number, int index) {
		if(index == 0) insertStart(number);
		if(index == this.getSize()-1) insertEnd(number);
		Node tmp1 = head;
		for(int i = 1; i < index; i++) tmp1 = tmp1.next;
		Node tmp2 = new Node(number);
		tmp1.next = tmp2.next;
		tmp1.next = tmp2;
		tmp2.prev = tmp1;
		tmp2.next.prev = tmp2;

	}
	
	// Removing i-th element of the list
	public int removeIndex(int index) throws StructureEmptyException {
		if(index == 0) return removeStart();
		if(index == this.getSize()-1) return removeEnd();
		Node tmp = head;
		for(int i = 1; i < index; i++) tmp = tmp.next;
		tmp.prev.next = tmp.next;
		tmp.next.prev = tmp.prev;
		return tmp.number;
	}
	
	// Getter for number of elements in the list
	public int getSize() {
		Node tmp = head;
		int i = 0;
		while(tmp != null) {
			i++;
			tmp = tmp.next;
		}
		return i;
	}
	
	// Textual representation of the list
	@Override
	public String toString() {
		String str = "";
		str += name + ": ";
		Node tmp = head;
		while(tmp !=null) {
			str+= tmp.number;
			if(tmp != tail) str += "->";
			tmp = tmp.next;
		}
 		return str;
	}
	
}
