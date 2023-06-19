package asp_library;

import Exceptions.StructureEmptyException;
import Exceptions.StructureFullException;

public class BinaryTree {
	private class Node {
		public Node(int number) {
			this.number = number;
			this.left = this.right = null;
		}
		private int number;
		private Node left;
		private Node right;
	}
	private Node root;
	private String name;
	private int size;
	
	// Constructor without initializing the name of the tree 
	public BinaryTree() {
		root = null;
		name = new String("");
		size = 0;
	}
	
	// Constructor with initializing the name of the tree
	public BinaryTree(String name) {
		root = null;
		this.name = name;
	}
	
	// Getter for the root of the tree
	public Node getRoot() {return this.root;}
	
	// Getter for the name of the tree
	public String getName() {return this.name;}
	
	// Setter for the name of the tree
	public void setName(String newName) {this.name = newName;}
	
	// Preorder traversal of the tree	
	public int[] preorder() {
		int [] ret = new int[this.getSize()];
		return ret;
	}
	
	// Inorder traversal of the tree
	public int[] inorder() {
		int [] ret = new int[this.getSize()];
		return ret;
	}
	
	// Postorder traversal of the tree
	public int[] postorder() {
		int [] ret = new int[this.getSize()];
		return ret;
	}
	
	// Levelorder traversal of the tree
	public int[] levelorder() throws StructureEmptyException, StructureFullException {
		int [] ret = new int[this.getSize()];
		return ret;
	}
	
	// Returns true if there is a node with a given number in the tree
	public boolean find(int number) {return false;}
	
	// Adding an element to the tree. Tree is always almost complete 
	public void addElem(int number) {
		if(root == null) {
			root = new Node(number);
			size++;
			return;
		}
		Node tmp = root;
		for(int i = 0; i < (int)(Math.log10(getSize()) / Math.log10(2)) + (((getSize()+1 & getSize()) == 0) ? 1:0);i++) {
			if(getSize() % Math.pow(2, i+1) <= Math.pow(2, i)) {
				if(tmp.left == null) {
					tmp.left = new Node(number);
				}
				else{tmp = tmp.left;}
			}
			else {
				if(tmp.right == null) {
					tmp.right = new Node(number);
				}
				else {tmp = tmp.right;}
			}
		}
		size++;
	}
	
	//Adding multiple elements to the tree. Tree is always almost complete
	public void addArray(int[] numbers) {
		for(int i = 0; i < numbers.length; i++) {
			addElem(numbers[i]);
		}
	}
	
	// Removing an element from the tree. Tree is always almost complete
	public int remove() throws StructureEmptyException {
		if(root == null) throw new StructureEmptyException("Binary Tree is empty.");
		Node tmp = root;
		for(int i = 0; i < (int)(Math.log10(getSize()) / Math.log10(2)) + (((getSize()+1 & getSize()) == 0) ? 1:0);i++) {
			if(getSize() % Math.pow(2, i+1) <= Math.pow(2, i)) {tmp = tmp.left;}
			else {tmp = tmp.right;}
		}
		int x = tmp.number;
		tmp = null;
		return x;
	}
	
	// Getter for the number of elements in the tree
	public int getSize() {return this.size;}

	//Textual representation of the tree
	@Override
	public String toString() {
		return "";
	}
	
	
}
