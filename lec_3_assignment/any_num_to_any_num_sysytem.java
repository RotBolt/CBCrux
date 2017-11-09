package lec_3_assignment;

import java.util.Scanner;

public class any_num_to_any_num_sysytem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N,sb,db;
		System.out.print("Enter the Number\n");
		N=in.nextInt();
		System.out.print("Enter the Number System of number entered\n");
		sb=in.nextInt();
		System.out.print("Enter the Number System to which you want to convert\n");
		db=in.nextInt();
		int result= any_to_any(N,sb,db);
		System.out.print("Converted Number is "+result);
		
	}

	public static int any_to_any(int number, int sb, int db){
		int dec_number=any_to_dec(number,sb);
		int result=dec_to_any(dec_number,db);
		return(result);
	}
	public static int any_to_dec(int number,int sb){
		int dec_number=0;
		int multiplier=1;
		while(number!=0){
			int digit=number%10;
			number=number/10;
			dec_number=digit*multiplier+dec_number;
			multiplier*=sb;
		}
		return(dec_number);
	}
	public static int dec_to_any(int number,int db){
		int result=0;
		int multiplier=1;
		while(number!=0){
			int digit=number%db;
			number=number/db;
			result=digit*multiplier+result;
			multiplier*=10;
		}
		return(result);
	}
}

