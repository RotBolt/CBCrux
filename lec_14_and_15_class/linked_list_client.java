package lec_14_and_15_class;

public class linked_list_client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Linked_list ll = new Linked_list();
		//Linked_list ll1 = new Linked_list();
		// ll.addfirst(9);
		// ll.display();
		// ll.addlast(7);
		// ll.display();
		// ll.addat(4, 1);
		// ll.display();
		// ll.addat(0, 0);
		// ll.display();
		// ll.addat(8, 4);
		// ll.display();
		// System.out.println(ll.getfirst());
		// System.out.println(ll.getlast());
		// System.out.println(ll.get_at(4));
		// System.out.println(ll.get_at(0));
		// System.out.println(ll.get_at(2));
		// System.out.println(ll.size());
		// ll.addfirst(9);
		// ll.display();
		// ll.addfirst(0);
		// ll.display();
		// //ll.remove_last();
		// //ll.display();
		// //ll.remove_last();
		// //ll.display();
		// ll.addfirst(-1);
		// ll.addfirst(-2);
		// ll.display();
		// ll.remove_at(1);
		// ll.display();
//		int i = 0;
//		while (i < 9) {
//			ll.addlast(i);
//			i++;
//		}
//		ll.display();
//		//ll.revPR(null,null,null,0);
//		//ll.display();
//		//System.out.println(ll.kthnode_from_end(3));
//		//System.out.println("**********************");
//		 i = 10;
//		while (i < 19) {
//			ll1.addlast(i);
//			i++;
//		}
//		ll1.display();
//		Linked_list llm = ll.merge(ll1);
//		llm.display();
		
//		int i = 10;
//		while (i >0) {
//			ll.addlast(i);
//			i--;
//		}
		ll.addlast(3);
		ll.addlast(1);
		ll.addlast(5);
		ll.addlast(2);
		ll.addlast(56);
		ll.addlast(12);
		ll.addlast(0);
		ll.display();
		Linked_list llres=ll.ll_merge_sort(ll);
		llres.display();
	}

}
