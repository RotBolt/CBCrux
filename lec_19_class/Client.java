package lec_19_class;

import lec_19_class.HashTable;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashTable<String, Integer> map = new HashTable<>();
		try {
			map.put("Rohan", 15);
			map.display();
			map.put("Rituka", 21);
			map.display();
			map.put("Mayank", 19);
			map.display();
			map.put("Abhi", 72);
			map.display();
			
			System.out.println(map.remove("Arvind"));
			map.display();

			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

