package lec_11_class;

public class Dynamic_stack_inherit extends Stack_Arrays {
       public Dynamic_stack_inherit(){
    	   this(def_cap);
       }
       public Dynamic_stack_inherit(int cap){
    	   super(cap);
       }
       public void push(int item) throws Exception{
    	   if(this.size()==this.data.length){
    		   int [] temp=new int[2*this.data.length];
    		   for(int i=0;i<this.data.length;i++){
    			   temp[i]=this.data[i];
    		   }
    		   this.data=temp;
    	   }
    	   super.push(item);
       }
}
