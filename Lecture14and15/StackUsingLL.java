package Lecture14and15;

public class StackUsingLL {

	private LinkedList list;

	public StackUsingLL() {
		// TODO Auto-generated constructor stub
		this.list = new LinkedList();
	}

	public int size() {
		return this.list.size();
	}

	public boolean isEmpty() {
		return this.list.isEmpty();

	}

	public void push(int item) {
		this.list.addFirst(item);
	}

	public int pop() throws Exception {
		int rv = 0;
		try {
			rv = this.list.removeFirst();

		} catch (Exception e) {
			throw new Exception("Stack is Empty");
		}
		return rv;
	}

	public int top() throws Exception {
		int rv = 0;
		try {
			rv = this.list.getFirst();

		} catch (Exception e) {
			throw new Exception("Stack is Empty");
		}
		return rv;
	}

	public void display() throws Exception {
		try {
			this.list.display();

		} catch (Exception e) {
			throw new Exception("Stack is Empty");
		}
	}
}
