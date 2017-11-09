package lec_13_class;
public class Q_using_stacks_client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		QUSefficeient q=new QUSefficeient();
		for(int i=1;i<=5;i++){
			q.enque(i);
			q.display();
			System.out.println("***********");
		}
		while(!q.isempty()){
			q.deque();
			q.display();
			System.out.println("***********");
		}
	}

}
