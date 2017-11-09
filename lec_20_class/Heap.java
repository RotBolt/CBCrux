package lec_20_class;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {
	private ArrayList<T> data;
	private boolean isMin;

	Heap() {
		this(false);
	}

	public Heap(boolean isMin) {
		this.data = new ArrayList<>();
		this.isMin = isMin;
	}

	public Heap(T[] arr, boolean isMin) {
		this(isMin);
		for (int i = 0; i < arr.length; i++) {
			this.data.add(arr[i]);
		}
		for (int i = (arr.length / 2) - 1; i >= 0; i--) {
			this.downHeapify(i);
		}
	}

	public T get() {
		return data.get(0);
	}

	public int size() {
		return this.data.size();
	}

	public boolean isEmpty() {
		return this.data.size() == 0;
	}

	public void add(T data) {
		this.data.add(data);
		this.upHeapify(this.size() - 1);

	}

	private void upHeapify(int ci) {
		if (ci == 0) {
			return;
		}
		int pi = (ci - 1) / 2;
		if (!isLarger(pi, ci)) {
			swap(pi, ci);
			this.upHeapify(pi);
		}
	}

	private void swap(int i, int j) {
		T temp = this.data.get(i);
		this.data.set(i, this.data.get(j));
		this.data.set(j, temp);
	}

	private boolean isLarger(int i, int j) {
		T item1 = this.data.get(i);
		T item2 = this.data.get(j);
		if (this.isMin) {
			return item1.compareTo(item2) > 0 ? false : true;
		}
		return item1.compareTo(item2) > 0 ? true : false;
	}

	public T remove() {
		T val = this.data.get(0);
		swap(0, this.data.size() - 1);
		this.data.remove(this.data.size() - 1);
		this.downHeapify(0);
		return val;
	}

	private void downHeapify(int pi) {

		int lc = 2 * pi + 1;
		int rc = 2 * pi + 2;
		int mi = pi;
		if (isLarger(lc, pi) && lc < this.data.size()) {
			mi = lc;
		}
		if (isLarger(rc, mi) && rc < this.data.size()) {
			mi = rc;
		}
		if (mi != pi) {
			this.swap(mi, pi);
			this.downHeapify(mi);
		}
	}

	private void display(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 1;
		T node = this.data.get(pi);
		String str = "";
		if (lci < this.data.size()) {
			T lc = this.data.get(lci);
			str += lc + "=>";
		} else {
			str += "END" + "=>";
		}
		str += node;
		if (rci < this.data.size()) {
			T rc = this.data.get(rci);
			str += "<=" + rc;
		} else {
			str += "<=" + "END";
		}
		System.out.println(str);
		if (lci < this.data.size()) {
			this.display(lci);
		}
		if (rci < this.data.size()) {
			this.display(rci);
		}

	}

}
