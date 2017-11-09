package lec_16_class;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import lec_4_class.mirror_inverse;

public class Generic_tree {
	private class node {
		private int data;
		ArrayList<node> children;

		node(int data) {
			this.data = data;
			children = new ArrayList<>();
		}
	}

	int size = 0;
	node root;

	Generic_tree() {
		Scanner in = new Scanner(System.in);
		this.root = take_input(in, null, 0);
	}

	private node take_input(Scanner in, node parent, int ithChild) {
		if (parent == null) {
			System.out.print("Enter data for root\n");
		} else {
			System.out.println("Enter the data for " + ithChild + " child of " + parent.data);
		}
		int val = in.nextInt();
		node NODE = new node(val);
		this.size++;
		System.out.println("Enter the number of children for" + NODE.data);
		int num_of_child = in.nextInt();
		for (int i = 0; i < num_of_child; i++) {
			node child = take_input(in, NODE, i);
			NODE.children.add(child);
		}
		return NODE;
	}

	public void display() {
		this.display(this.root);
	}

	private void display(node NODE) {
		System.out.print(NODE.data + " => ");
		for (int i = 0; i < NODE.children.size(); i++) {
			System.out.print(NODE.children.get(i).data + ", ");
		}
		System.out.println("END");
		for (int i = 0; i < NODE.children.size(); i++) {
			display(NODE.children.get(i));
		}
	}

	public int size2() {
		int rv = this.size2(this.root);
		return rv;
	}

	private int size2(node NODE) {
		if (NODE.children.size() == 0) {
			return 1;
		}
		int count = 1;
		for (int i = 0; i < NODE.children.size(); i++) {
			count += size2(NODE.children.get(i));
		}
		return count;
	}

	public int max() {
		return this.max(Integer.MIN_VALUE, this.root);
	}

	private int max(int max, node NODE) {
		if (NODE.data > max) {
			max = NODE.data;
		}
		if (NODE.children.size() == 0) {
			return max;
		}

		for (int i = 0; i < NODE.children.size(); i++) {
			max = max(max, NODE.children.get(i));
		}
		return max;

	}

	public int height() {
		return this.height(this.root, 0);
	}

	private int height(node NODE, int ini) {
		if (NODE.children.size() == 0) {
			return ini;
		}
		int prev_max = 0;
		for (int i = 0; i < NODE.children.size(); i++) {
			int rec_height = height(NODE.children.get(i), ini + 1);
			prev_max = Math.max(prev_max, rec_height);
		}
		return prev_max;
	}

	public boolean find(int item) {
		return this.find(this.root, item);
	}

	private boolean find(node NODE, int item) {
		if (NODE.data == item) {
			return true;
		}
		if (NODE.children.size() == 0) {
			return false;
		}
		boolean res = false;
		for (int i = 0; i < NODE.children.size(); i++) {
			res = find(NODE.children.get(i), item);
			if (res == true) {
				return true;
			}

		}
		return res;
	}

	public void mirror() {
		this.mirror(this.root);
	}

	private void mirror(node NODE) {
		if (NODE.children.size() == 0) {
			return;
		}
		for (int i = 0; i < NODE.children.size(); i++) {
			mirror(NODE.children.get(i));
			for (int j = 0, k = NODE.children.size() - 1; j < NODE.children.size() / 2; j++, k--) {
				node n1 = NODE.children.get(j);
				node n2 = NODE.children.get(k);
				NODE.children.set(j, n2);
				NODE.children.set(k, n1);
			}
		}
	}

	public void print_at_level(int level) {
		this.print_at_level(level, this.root, 0);
	}

	private void print_at_level(int level, node NODE, int ini) {
		if (ini == level) {
			System.out.print(NODE.data + ", ");
			return;
		}
		if (NODE.children.size() == 0) {
			return;
		}
		for (int i = 0; i < NODE.children.size(); i++) {
			print_at_level(level, NODE.children.get(i), ini + 1);
		}
	}

	public void pre_order_traversal() {
		this.pre_order_traversal(this.root);
	}

	private void pre_order_traversal(node NODE) {
		System.out.println(NODE.data);
		if (NODE.children.size() == 0) {
			return;
		}
		for (int i = 0; i < NODE.children.size(); i++) {
			pre_order_traversal(NODE.children.get(i));
		}
		return;
	}

	// big complexity***********************
	public void level_order_traversal() {
		this.level_order_traversal(this.root);
	}

	private void level_order_traversal(node NODE) {
		for (int i = 0; i <= this.height(); i++) {
			this.print_at_level(i);
			System.out.println();
		}
	}

	// **************************************
	public void post_order_traversal() {
		this.post_order_traversal(this.root);
	}

	private void post_order_traversal(node NODE) {
		if (NODE.children.size() == 0) {
			System.out.print(NODE.data + " ");
			return;
		}
		for (int i = 0; i < NODE.children.size(); i++) {
			post_order_traversal(NODE.children.get(i));
		}
		System.out.print(NODE.data + " ");
		return;
	}

	public void level_order_traversal_beta() {
		this.level_order_taversal_beta(this.root);
	}

	private void level_order_taversal_beta(node NODE) {
		Queue<node> Q = new LinkedList<>();
		Q.add(NODE);
		while (!Q.isEmpty()) {
			node temp = Q.poll();
			System.out.print(temp.data + ", ");
			for (int i = 0; i < temp.children.size(); i++) {
				Q.add(temp.children.get(i));
			}
		}
	}

}
