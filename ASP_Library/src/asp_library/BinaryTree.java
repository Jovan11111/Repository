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
	public void addElem(int number) {}
	
	//Adding multiple elements to the tree. Tree is always almost complete
	public void addArray(int[] numbers) {}
	
	// Removing an element from the tree. Tree is always almost complete
	public int remove() {return 0;}
	
	// Getter for the number of elements in the tree
	public int getSize() {return this.size;}
}
