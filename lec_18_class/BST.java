package lec_18_class;

import java.util.ArrayList;

public class BST {
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
	Node root;

	BST() {
		this.root = null;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void add(int data) {
		if (this.isEmpty()) {
			this.root = new Node(data, null, null);
			this.size++;
		} else {
			add(this.root, data);
		}
	}

	private void add(Node node, int data) {

		if (node.data > data) {
			if (node.left == null) {
				node.left = new Node(data, null, null);
				this.size++;
			} else {
				add(node.left, data);
			}
		} else if (node.data == data) {
			System.out.println(data + " is duplicate value can't be added");
		} else {
			if (node.right == null) {
				node.right = new Node(data, null, null);
				this.size++;
			} else {
				add(node.right, data);
			}
		}
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

	public int max() {
		return max(this.root, Integer.MIN_VALUE);
	}

	private int max(Node node, int max) {
		if (node == null) {
			return max;
		}
		if (node.data > max) {
			max = node.data;
		}
		max = max(node.right, max);
		return max;
	}

	public int min() {
		return min(this.root, Integer.MAX_VALUE);
	}

	private int min(Node node, int min) {
		if (node == null) {
			return min;
		}
		if (node.data < min) {
			min = node.data;
		}
		min = min(node.left, min);
		return min;
	}

	public void remove(int data) {
		remove(this.root, data);
	}

	private Node remove(Node node, int data) {
		if (node.data > data) {
			node.left = this.remove(node.left, data);
			return node;
		} else if (node.data < data) {
			node.right = this.remove(node.right, data);
			return node;
		} else {
			if (node.right == null && node.left == null) {
				this.size--;
				return null;
			} else if (node.right == null) {
				this.size--;
				return node.left;
			} else if (node.left == null) {
				this.size--;
				return node.right;
			} else {
				int lmax = max(node.left, Integer.MIN_VALUE);
				node.data = lmax;
				node.left = this.remove(node.left, lmax);
				return node;
			}
		}
	}

	public boolean isBST() {
		return isBST(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		boolean lres = false;
		boolean rres = false;
		boolean fres = false;
		if (node.data < max && node.data > min) {
			lres = isBST(node.left, min, node.data);
			rres = isBST(node.right, node.data, max);
			if (lres && rres) {
				fres = true;
			}
		}
		if (node.data < min || node.data > max) {
			return false;
		}
		return fres;

	}

	class BST_ele {
		int height;
		int diameter;

		BST_ele() {
			height = -1;
			diameter = 0;
		}
	}

	public int diameter() {
		return BST_ele_give(this.root).diameter;
	}

	public BST_ele BST_ele_give(Node node) {
		if (node == null) {
			BST_ele base = new BST_ele();
			return base;
		}

		BST_ele my_res = new BST_ele();
		BST_ele lres = BST_ele_give(node.left);
		BST_ele rres = BST_ele_give(node.right);
		int lheight = lres.height + 1;
		int rheight = rres.height + 1;
		int ldia = lres.diameter;
		int rdia = rres.diameter;
		int tdia = lres.height + rres.height + 2;
		my_res.height = Math.max(rheight, lheight);
		my_res.diameter = Math.max(tdia, Math.max(rdia, ldia));
		return my_res;
	}

	public int diameter_alpha() {
		return diameter_alpha(this.root);
	}

	private int diameter_alpha(Node node) {
		if (node == null) {
			return -1;
		}
		int lh = diameter_alpha(node.left);
		int rh = diameter_alpha(node.right);
		int ldia = lh + 1;
		int rdia = rh + 1;
		int tdia = lh + rh + 2;
		return Math.max(tdia, Math.max(rdia, ldia));

	}

	private class index {
		int indi;

		index() {
			this.indi = 0;
		}
	}

	public void replace_nodes_sum() {
		ArrayList<Integer> list = new ArrayList<>();
		int list_sum = inOrder_store(this.root, list);
		int ele_sum = 0;
		for (int i = 0; i < list.size() - 1; i++) {
			ele_sum += list.get(i);
			int g_sum = list_sum - ele_sum;
			list.set(i, g_sum);
		}

		inOrder_replace(this.root, list, new index());

	}

	private int inOrder_store(Node node, ArrayList<Integer> list) {
		if (node == null) {
			return 0;
		}
		int sum = 0;
		sum += inOrder_store(node.left, list);
		list.add(node.data);
		sum += node.data;
		sum += inOrder_store(node.right, list);

		return sum;

	}

	private void inOrder_replace(Node node, ArrayList<Integer> list, index pos) {
		if (node == null) {
			return;
		}

		inOrder_replace(node.left, list, pos);
		node.data = list.get(pos.indi);
		pos.indi++;
		inOrder_replace(node.right, list, pos);

	}
}
