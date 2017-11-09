package lec_4_class;

import java.util.Scanner;

public class bin_search {

	private static Scanner in;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		System.out.println("Enter the num to be found");
		in = new Scanner(System.in);
		int num = in.nextInt();
		int index = binary_search(arr, num);
		System.out.print("Index of the num is " + index);
	}

	public static int binary_search(int[] arr, int num) {
		int left = 0;// lest most index
		int right = arr.length - 1;// right most index
		int mid = (left + right) / 2;
		while (left <= right) {
			if (arr[mid] == num)
				return (mid);
			else if (arr[mid] < num) {
				left = mid + 1;
				mid = (left + right) / 2;
			} else {
				right = mid - 1;
				mid = (left + right) / 2;
			}
		}
		return (-1);
	}
}
