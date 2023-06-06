package asp_library;

import Exceptions.StructureEmptyException;

public class SinglyLinkedList {
	private class Node{
		public Node(int number) {
			this.number = number;
			next = null;
		}
		private int number;
		private Node next;
	}
	private Node head;
	private Node tail;
	private String name;
	
	// Constructor without initializing the name of the list 
	public SinglyLinkedList(){
		head = null;
		tail = null;
		name = new String("");
	}
	
	// Constructor with initializing the name of the list
	public SinglyLinkedList(String name) {
		this.name = name;
		head = null;
		tail = null;
	}
	
	// Getter for the name of the list
	public String getName() {return this.name;}
	
	// Setter for the name of the list
	public void setName(String newName) {this.name = newName;}
	
	// Inserting an element at the start of the list
	public void insertStart(int number) {
		if(head == null) {
			head = new Node(number);
		}
		else if(tail == null) {
			tail = head;
			head = new Node(number);
			head.next = tail;
		}
		else {
			Node tmp = new Node(number);
			tmp.next = head;
			head = tmp;
		}
	}
	
	// Inserting an element at the end of the list
	public void insertEnd(int number) {
		if(head == null) {
			head = new Node(number);
		}
		else if(tail == null) {
			tail = new Node(number);
			head.next = tail;
		}
		else {
			tail.next = new Node(number);
			tail = tail.next;
		}
	}
	
	// Removing an element from the start of the list
	public int removeStart() throws StructureEmptyException {
		if(head == null) throw new StructureEmptyException("Singly linked list is empty");
		Node tmp = head;
		head = head.next;
		int x = tmp.number;
		tmp = null;
		return x;
	}
	
	// Removing an element from the end of the list
	public int removeEnd() throws StructureEmptyException {
		if(head == null) throw new StructureEmptyException("Singly linked list is empty");
		if(tail == null) {
			int x = head.number;
			head = null;
			return x;
		}
		Node tmp = head;
		while(tmp.next != tail) tmp = tmp.next;
		tail = tmp;
		int x = tail.next.number;
		tail.next = null;
		return x;
	}
	
	// Inserting at the i-th place in the list
	public void insertIndex(int number, int index) {
		if( index >= this.getSize() || index < 0) throw new IndexOutOfBoundsException();
		if(index == 0) {
			insertStart(number); return;
		}
		if(index == this.getSize()-1) {
			insertEnd(number); return;
		}
		Node tmp1 = head;
		for(int i = 1; i < index; i++) tmp1 = tmp1.next;
		Node tmp2 = tmp1.next;
		tmp1.next = new Node(number);
		tmp1.next.next = tmp2;
	}
	
	// Removing i-th element of the list
	public int removeIndex(int index) throws StructureEmptyException {
		if(index >= this.getSize() || index < 0) throw new IndexOutOfBoundsException();
		if(index == 0) return removeStart();
		if(index == this.getSize()-1) return removeEnd();
		Node tmp1 = head;
		for(int i = 1; i < index; i++) tmp1 = tmp1.next;
		Node tmp2 = tmp1.next;
		int x = tmp2.number;
		tmp1.next = tmp2.next;
		tmp2 = null;
		return x;
	}
	
	// Getter for number of elements in the list
	public int getSize() {
		Node tmp = head;
		int i = 0;
		while(tmp !=null) {
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
