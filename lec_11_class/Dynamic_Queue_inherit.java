package lec_11_class;

public class Dynamic_Queue_inherit extends Queue_array {
	public Dynamic_Queue_inherit() {
		this(def_cap);
	}

	public Dynamic_Queue_inherit(int cap) {
		super(cap);
	}
	 public void enque(int item) throws Exception{
  	   if(this.size()==this.data.length){
  		   int [] temp=new int[2*this.data.length];
  		   for(int i=0;i<this.data.length;i++){
  			   temp[i]=this.data[(front+i)%this.data.length];
  			   //temp[i]=this.data[i];
  		   }
  		   this.data=temp;
  		   this.front=0;
  	   }
  	   super.enque(item);
     }
		
	
}
