package lec_2_assignment;

import java.util.Scanner;

public class isPrime {
    static Scanner in= new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=in.nextInt();
		boolean check=isPrime(num);
		System.out.println(check);

	}
	public static boolean isPrime(int num){
		int div=2;
		while(div<(num/2)){
			if(num%div==0){
				return false;
			}
			div++;
		}
		return true;
	}

}
