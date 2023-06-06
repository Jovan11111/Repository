package asp_library;

import Exceptions.StructureEmptyException;

public class Queue {
	private int front;
	private int rear;
	private int size;
	private int [] queue;
	private String name;
	
	// Constructor without initializing the name of the queue
	public Queue(int size) {
		this.size = size;
		front = rear = 0;
		queue = new int[size];
		this.name = new String("");
	}
	
	// Constructor with initializing the name of the queue
	public Queue(int size, String name) {
		this.size = size;
		this.name = name;
		front = rear = 0;
		queue = new int[size];
	}
	
	// Getter for the size of the queue
	public int getSize() {return this.size;}
	
	// Getter for the name of the queue
	public String getName() {return this.name;}
	
	// Setter for the name of the queue
	public void setName(String newName) {this.name = newName;}
	
	// Inserting an element into the queue
	public void insert(int number) {}
	
	// Deleting an element from the queue
	public int delete() throws StructureEmptyException{
		if(rear == front) throw new StructureEmptyException("Queue is empty");
		
		return 0;
	}
	
	
	

}
