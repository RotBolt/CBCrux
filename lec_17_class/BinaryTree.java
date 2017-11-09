package lec_17_class;

import java.util.Queue;
import java.util.Scanner;

import Lecture14and15.Generics.LinkedList;

public class BinaryTree {
	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;

		}
	}

	private int size;
	private Node root;

	public BinaryTree() {
		Scanner s = new Scanner(System.in);
		this.root = takeInput(s, null, false);
	}

	private Node takeInput(Scanner s, Node parent, boolean isLeftOrRight) {
		if (parent == null) {
			System.out.println("Enter the data for root");
		} else {
			if (isLeftOrRight) {
				System.out.println("Enter the data for left child of " + parent.data);
			} else {
				System.out.println("Enter the data for right child of " + parent.data);
			}
		}

		int nodeData = s.nextInt();
		Node node = new Node(nodeData, null, null);
		this.size++;

		boolean choice = false;
		System.out.println("Do you have left child for " + node.data);
		choice = s.nextBoolean();
		if (choice) {
			node.left = takeInput(s, node, true);
		}

		System.out.println("Do you have right child for " + node.data);
		choice = s.nextBoolean();
		if (choice) {
			node.right = takeInput(s, node, false);
		}
		return node;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {
		this.display(this.root);
	}

	private void display(Node node) {
		if (node.left != null) {
			System.out.print(node.left.data + "=>");
		} else {
			System.out.print("END=>");
		}
		System.out.print(node.data);

		if (node.right != null) {
			System.out.print("<=" + node.right.data);
		} else {
			System.out.print("<=END");
		}
		System.out.println();
		if (node.left != null) {
			this.display(node.left);
		}
		if (node.right != null) {
			this.display(node.right);
		}
	}

	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;
		}

		int rv = 0;
		int lSize = this.size2(node.left);
		int rSize = this.size2(node.right);

		rv = lSize + rSize + 1;

		return rv;
	}

	public int min() {
		return this.min(this.root);
	}

	private int min(Node node) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}

		int rv = node.data;
		int lMin = this.min(node.left);
		int rMin = this.min(node.right);

		rv = Math.min(rv, Math.min(lMin, rMin));

		return rv;

	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int rv = node.data;
		int lMax = this.max(node.left);
		int rMax = this.max(node.right);

		rv = Math.max(rv, Math.max(lMax, rMax));

		return rv;

	}

	public boolean find(int item) {
		return this.find(item, this.root);
	}

	private boolean find(int item, Node node) {

		if (node == null) {
			return false;
		}

		if (node.data == item) {
			return true;
		}

		if (this.find(item, node.left)) {
			return true;
		}

		if (this.find(item, node.right)) {
			return true;
		}

		return false;
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		System.out.println("H");

		int lh = this.height(node.left);
		int rh = this.height(node.right);

		int h = Math.max(lh, rh);

		return h + 1;
	}

	public void mirror() {
		this.mirror(this.root);
	}

	private void mirror(Node node) {

		if (node == null) {
			return;
		}
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;

		this.mirror(node.left);
		this.mirror(node.right);
	}

	public void preOrder() {
		this.preOrder(this.root);
		System.out.print("END");
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + ",");
		preOrder(node.left);
		preOrder(node.right);

	}

	public void postOrder() {
		this.postOrder(this.root);
		System.out.print("END");
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}

		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + ",");

	}

	public void inOrder() {
		this.inOrder(this.root);
		System.out.print("END");
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.print(node.data + ",");
		inOrder(node.right);

	}

	public void preOrderIterative() throws Exception {
		LinkedList<Node> stack = new LinkedList<>();
		stack.addFirst(this.root);
		while (!stack.isEmpty()) {
			Node temp = stack.removeFirst();
			System.out.print(temp.data + ",");

			if (temp.right != null) {
				stack.addFirst(temp.right);
			}
			if (temp.left != null) {
				stack.addFirst(temp.left);
			}
		}
		System.out.print("END");
	}

	public void levelOrderIterative() {
		Queue<Node> queue = new java.util.LinkedList<>();

		queue.add(this.root);

		while (!queue.isEmpty()) {

			Node temp = queue.remove();
			System.out.print(temp.data + ", ");

			if (temp.left != null) {
				queue.add(temp.left);

			}

			if (temp.right != null) {
				queue.add(temp.right);

			}
		}

		System.out.println("END");
	}

	public int lca(int d1, int d2) {
		return this.lca(d1, d2, this.root).data;
	}

	private Node lca(int d1, int d2, Node node) {

		if (node == null) {
			return null;
		}

		if (node.data == d1 || node.data == d2) {
			return node;
		}

		Node llca = this.lca(d1, d2, node.left);
		Node rlca = this.lca(d1, d2, node.right);

		if (llca != null && rlca != null) {
			return node;
		} else if (llca != null) {
			return llca;
		} else if (rlca != null) {
			return rlca;
		} else {
			return null;
		}
	}

	public boolean isBST() {
		return isBST(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(Node node, int min, int max) {

		if (node == null) {
			return true;
		}

		if (node.data < min || node.data > max) {
			return false;
		}

		if (!this.isBST(node.left, min, node.data)) {
			return false;
		}

		if (!this.isBST(node.right, node.data, max)) {
			return false;
		}

		return true;
	}

	public int diameter() {
		return this.diameterBtr(this.root).diameter;
	}

	private int diameter(Node node) {

		if (node == null) {
			return 0;
		}

		int f1 = this.height(node.left) + this.height(node.right) + 2;
		int f2 = this.diameter(node.left);
		int f3 = this.diameter(node.right);

		return Math.max(f1, Math.max(f2, f3));
	}

	private class Pair {
		int height;
		int diameter;
		
		public Pair(int height, int diameter) {
			this.height = height;
			this.diameter = diameter;
			System.out.println("H");
			
		}
	}

	private Pair diameterBtr(Node node) {

		if (node == null) {
			Pair base = new Pair(0,0);
			base.height = -1;
			base.diameter = 0;
			return base;

		}


		Pair myPair = new Pair(0,0);

		Pair lResult = this.diameterBtr(node.left);
		Pair rResult = this.diameterBtr(node.right);
		int lh = lResult.height;
		int ld = lResult.diameter;
		int rh = rResult.height;
		int rd = rResult.diameter;

		myPair.height = Math.max(lh, rh) + 1;
		int f1 = lh + rh + 2;
		int f2 = ld;
		int f3 = rd;
		myPair.diameter = Math.max(f1, Math.max(f2, f3));

		return myPair;
	}
}
