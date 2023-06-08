package asp_library;

public class NaryTree {
	private class Node{}
	private Node root;
	private String name;
	private int size;
	private int n;
	
	public NaryTree(int n) {}
	
	public NaryTree(int n, String name) {}
	
	public Node getRoot() {return this.root;}
	
	public String getName() {return this.name;}
	
	public void setName(String newName) {this.name = newName;}
	
	public int[] preorder() {return new int[10];}
	
	public int[] inorder() {return new int[10];}
	
	public int[] postorder() {return new int[10];}
	
	public int[] levelorder() {return new int[10];}
	
	public boolean find(int number) {return false;}
	
	public void addElem(int number) {}
	
	public void addArray(int[] numbers) {}
	
	public int remove() {return 0;}
	
	public int getSize() {return this.size;}
}
