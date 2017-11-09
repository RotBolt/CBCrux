package lec_3_assignment;

import java.util.Scanner;

public class integral_part_of_root {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number\n");
		float num=in.nextFloat();
		int int_root=integral_part_root(num);
		System.out.print("Integral part of root of number is "+ int_root);
		return;
	}

	public static int integral_part_root(float number) {
		int int_root = 0;
		while (int_root * int_root <= number) {
			int_root++;
		}
		int_root -= 1;
		return (int_root);
	}
}
