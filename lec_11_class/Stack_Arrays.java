package lec_11_class;

public class Stack_Arrays {

	protected int[] data;
	protected int tos;
	protected static final int def_cap = 10;

	public Stack_Arrays() {
		this(def_cap);
	}

	public Stack_Arrays(int cap) {
		this.data = new int[cap];
		this.tos = -1;
	}

	public int size() {
		return this.tos + 1;
	}

	public boolean isEmpty() {
		if (this.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void push(int item) throws Exception {
		if (this.size() == this.data.length) {
			throw new Exception("Stack is Full\n");
		}
		this.tos++;
		this.data[tos] = item;
	}

	public int pop() throws Exception {
		if (this.size() == 0) {
			throw new Exception("Stack is Empty\n");
		}
		int retval = this.data[tos];
		this.data[tos] = 0;
		this.tos--;
		return retval;
	}

	public int top() throws Exception {
		if (this.size() == 0) {
			throw new Exception("Stack is Empty");
		}
		return this.data[tos];
	}

	public void display() {
		if (this.size() == 0) {
			System.out.println("Stack is Empty\n");
			return;
		}
		for (int i = tos; i >= 0; i--) {
			System.out.print(this.data[i] + ", ");
		}
		System.out.println("END");
	}

}
