package lec_11_class;

public class Queue_rev {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Queue_array q = new Queue_array();
		 for(int i=1;i<=5;i++){
	    	  q.enque(i);;
	      }
	      q.display();
	      rev_queue(q);
	      q.display();
	}

	static public void rev_queue(Queue_array q) throws Exception {
		if (q.size == 0) {
			return;
		}
		int item = q.deque();
		rev_queue(q);
		q.enque(item);
	}
}
