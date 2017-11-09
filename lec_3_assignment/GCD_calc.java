package lec_3_assignment;

import java.util.Scanner;

public class GCD_calc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.print("Enter greater no\n");
		int dividend = in.nextInt();
		System.out.print("Enter the smaller no\n");
		int divisor = in.nextInt();
		in.close();
		int GCD = GCD_Calc(dividend, divisor);
		System.out.print("GCD of " + dividend + " and " + divisor + " is " + GCD);
	}

	public static int GCD_Calc(int dividend, int divisor) {
		while (divisor != 0) {
			int remainder = dividend % divisor;
			dividend = divisor;
			divisor = remainder;
		}
		return (dividend);
	}
}
