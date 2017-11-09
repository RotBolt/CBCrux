package assignment_7;

public class Q_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(sum_of_digits("11228"));
	}
	public static int sum_of_digits(String str){
		if(str.length()==0){
			return 0;
		}
		int sum=0;
		int num=str.charAt(0)-48;
		sum+=num+sum_of_digits(str.substring(1));
		return sum;
	}

}
