package asp_library;

import Exceptions.StructureEmptyException;
import Exceptions.StructureFullException;

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
	public void insert(int number) throws StructureFullException {
		this.rear = this.rear % this.size + 1;
		if(this.rear == this.front) throw new StructureFullException("Queue is full");
		queue[rear] = number;
		if(this.front == 0) this.front = 1;
	}
	
	// Deleting an element from the queue
	public int delete() throws StructureEmptyException{
		if(front == 0) throw new StructureEmptyException("Queue is empty");
		int x = queue[front];
		if(front == rear) front = rear = 0;
		else front = front % size + 1;
		return x;
	}
	
	//Textual representation of the queue
	@Override
	public String toString() {
		String str = this.name + ": ";
		int x = front;
		while(x != rear) {
			str += queue[x] + " ";
			x = x % this.size + 1;
		}
		str+= queue[rear];
		return str;
	}
	
}
