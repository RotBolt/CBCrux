package lec_2_assignment;

import java.util.Scanner;

public class nth_fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		int num=in.nextInt();
		int n_fib=nth_fib(num);
		System.out.println(n_fib);

	}
	public static int nth_fib(int num){
		int count=2;
		int no0=0;
		int no1=1;
		int no2=0;
		while(count<=num){
			no2=no1+no0;
			no0=no1;
			no1=no2;
			count++;
		}
		return no1;
		
		
	}

}
