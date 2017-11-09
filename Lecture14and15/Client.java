package Lecture14and15;

public class Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();

		list.addFirst(50);
		list.display();

		list.addLast(60);
		list.display();

		list.addFirst(40);
		list.display();

		list.addAt(2, 55);
		list.display();

		list.addAt(4, 70);
		list.display();

		list.addAt(4, 65);
		list.display();

		list.addLast(75);
		list.display();
		list.addLast(0);
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.getAt(0));
		System.out.println(list.getAt(3));

		list.display();
		list.MergeSort();
		list.display();

		System.out.println(list.find(75));

		// System.out.println(list.removeFirst());
		// list.display();
		//
		// System.out.println(list.removeLast());
		// list.display();
		//
		// System.out.println(list.removeAt(2));
		// list.display();

		// list.reverseDI();
		// list.display();

		// list.reversePI();
		// list.display();

		// list.reversePR();
		// list.display();

		// list.reverseDR();
		// list.display();

		// System.out.println("The mid is " + list.mid());
		// System.out.println("Kth Node From End is " + list.KthNodeFromEnd(2));
		// System.out.println("**************************************************");
		// LinkedList other = new LinkedList();
		// other.addLast(75);
		// other.addLast(35);
		// other.addLast(45);
		// other.MergeSort();
		// other.display();
		// LinkedList rv = list.Merge(other);
		// rv.display();

	}

}
