package lec_3_assignment;

import java.util.Scanner;

public class Inverse_no {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int number;
		System.out.print("Enter the number(from 1 to n where n is no. of digits)\n");
		number = in.nextInt();
		int inverse = inverse_finder(number);
		System.out.print("Inverse of " + number + " is " + inverse);
	}

	public static int inverse_finder(int number) {
		int value = 0;
		int position = 1;
		while (number != 0) {
			int multiplier = 1;
			int digit = number % 10;
			number = number / 10;
			while (digit > 1) {
				multiplier *= 10;
				digit--;
			}
			value = position * multiplier + value;
			position++;
		}
		return (value);
	}

}
