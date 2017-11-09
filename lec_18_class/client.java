package lec_18_class;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST obj = new BST();
		obj.add(50);
		obj.add(25);
		obj.add(75);
		obj.add(12);
		obj.add(49);
		obj.add(55);

		obj.display();

		System.out.println("*******************************");

		obj.replace_nodes_sum();

		obj.display();

	}

}
