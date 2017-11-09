package lec_11_class;

public class Queue_array {
	protected int[] data;
	protected int size;
	protected int front;
	protected static final int def_cap = 10;

	public Queue_array() {
		this(def_cap);
	}

	public Queue_array(int cap) {
		this.data = new int[cap];
		this.front = 0;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public void enque(int item) throws Exception {
		if (this.size == this.data.length) {
			throw new Exception("Queue is Full");
		}
		int ai = (this.front + this.size) % this.data.length;
		this.data[ai] = item;
		this.size++;
	}

	public int deque() throws Exception {
		if (this.size == 0) {
			throw new Exception("Queue is empty");
		}
		int retval = this.data[front];
		this.data[front] = 0;
		this.front = (this.front + 1) % this.data.length;
		this.size--;
		return retval;
	}

	public boolean isempty() {
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void display() throws Exception {
		if (isempty()) {
			System.out.println("Queue is Empty");
			return;
		}
		for (int i = 0; i < this.size; i++) {
			int ai = (this.front + i) % this.data.length;
			System.out.print(this.data[ai] + "<=");
		}
		System.out.println("END");
	}

	public int front() {
		return this.data[front];
	}
}
