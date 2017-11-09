package lec_4_class;

import java.util.Scanner;

public class twist_array_mid_point {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = take_input();
		System.out.print("\n\nYour entered array is \n");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println("\n********************************");
		twist_array(arr);
		System.out.println("After twisting\n");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}

	public static void twist_array(int[] arr) {
		int i = 0;// left most index
		int j = arr.length - 1;// right most index
		int mid = (i + j) / 2;
		for (; j > mid; i++, j--) {
			arr[i] = arr[i] + arr[j];
			arr[j] = arr[i] - arr[j];
			arr[i] = arr[i] - arr[j];
		}
	}

	public static int[] take_input() {
		System.out.println("Entern the size of array");
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.println("Enter the "+i+"th element");
			arr[i] = in.nextInt();
		}
		return (arr);
	}
}
