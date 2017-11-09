package lec_4_class;

import java.util.Scanner;

public class linear_search_array {
	public static void main() {
		int[] arr = { 10, 20, 30, 50 };
		int num;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter number to be found\n");
		num = in.nextInt();
		int index = linear_search(arr, num);
		System.out.print("Index of num is " + index);
	}

	public static int linear_search(int[] arr, int num) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num)
				return (i);
		}
		return (-1);
	}
}
