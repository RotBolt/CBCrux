package lec_11_class;

public class Stack_arrays_client {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
        Stack_Arrays obj= new Dynamic_stack_inherit();
        for(int i=1;i<=5;i++){
        	obj.push(i);
        	obj.display();
        	System.out.println(obj.size());
        	System.out.println("*************");
        }
        
        for(int i=1;i<=5;i++){
        	obj.push(i*10);
        	obj.display();
        	System.out.println(obj.size());
        	System.out.println("*************");
        }
	}

}
