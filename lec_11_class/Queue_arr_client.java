package lec_11_class;

public class Queue_arr_client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Queue_array q = new Dynamic_Queue_inherit(5);
		/*for (int i = 1; i <= 5; i++) {
			q.enque(i);
			q.display();
		}
		for (int i = 1; i <= 5; i++) {
			q.enque(i*10);
			q.display();
		}
		System.out.println("****************");
		while (!q.isempty()) {
			System.out.println("Front = " + q.front());
			System.out.println("Size =" + q.size());
			q.deque();
			q.display();
			System.out.println();
		}*/
		for (int i = 1; i <= 5; i++) {
			q.enque(i);
			System.out.println("Front = " + q.front());
			System.out.println("Size =" + q.size());
			q.display();
			System.out.println("*****************");
		}
		for(int i=0;i<2;i++){
			System.out.println(q.deque());
			q.display();
			System.out.println("*****************");
		}
		for(int i=0;i<2;i++){
			q.enque(i);
			System.out.println("Front = " + q.front());
			System.out.println("Size =" + q.size());
			q.display();
			System.out.println("*****************");
		}
		q.enque(8);
		System.out.println("Front = " + q.front());
		System.out.println("Size =" + q.size());
		q.display();
		System.out.println("*****************");
		
	}

}
