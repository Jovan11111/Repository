package asp_library;

import java.util.Arrays;

import Exceptions.*;

public class Stack {
	private int size;
	private int[] stack;
	private int sp;
	private String name;
	
	// Constructor without initializing the name of the stack
	public Stack(int size) {
		this.size = size;
		stack = new int[size];
		sp = 0;
		this.name = new String("");
	}
	 // Constructor with initializing the name of the stack
	public Stack(int size, String name) {
		this.size = size;
		this.name = name;
		stack = new int[size];
		sp = 0;
	}
	
	// Getter for the size of the Stack
	public int getSize() {return this.size;}
	
	// Pushing an element on the stack
	public void push(int number) throws StructureFullException {
		if(stack.length - 1 == sp) throw new StructureFullException("Stack is full");
		stack[sp++] = number;
	}
	
	// Popping an element off of the stack
	public int pop() throws StructureEmptyException {
		if(sp == 0) throw new StructureEmptyException("Stack is empty");
		return stack[--sp];
	}
	
	// Getter for the name of the stack
	public String getName() {return this.name;}
	
	// Setter for the name of the stack
	public void setName(String newName) {this.name = newName;}

	// Textual representation of the stack
	@Override
	public String toString() {
		String str = this.name + "(" + this.size + "): [";
		for(int i = 0; i < sp; i++) {
			str += stack[i];
			if(sp-1 != i) {
				str+= ", ";
			}
		}
		str+="]";
		return str;
	}
	
}
