package lec_10_class;

public class polynomial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(power_better(2,3));
	}
	public static int power_better(int x, int n){
		if(n==1){
			return x;
		}
		int powerN=1;
		if(n%2==0){
			int power_n_by_2=power_better(x,n/2);
			powerN=power_n_by_2*power_n_by_2;
		}else{
			int power_n_by_2=power_better(x,n/2);
			powerN=power_n_by_2*power_n_by_2*2;
		}
		return powerN;
		
	}

}
