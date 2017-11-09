package lec_20_class;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static class Student implements Comparable<Student> {
		int marks;
		int rank;
		String name;

		public Student(String name, int marks, int rank) {
			this.name = name;
			this.marks = marks;
			this.rank = rank;
		}

		public String toString() {
			return "{" + this.name + " M=" + this.marks + " R =" + this.rank;
		}

		public int compareTo(Student o) {
			return this.marks - o.marks;
		}
	}
	
	public static void downHeapify(int pi,int lp, int [] arr) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int mi = pi;
		if (arr[lci]>arr[mi] && lci < arr.length) {
			mi = lci;
		}
		if (arr[rci]>arr[mi] && rci < arr.length) {
			mi = rci;
		}
		if (mi != pi) {
			swap(mi, pi,arr);
			downHeapify(mi,lp,arr);
		}
	}
	
	public static void swap(int i, int j, int [] arr) {
		int temp = arr[i];
		arr[i]= arr[j];
		arr[j]=temp;
	}



}
