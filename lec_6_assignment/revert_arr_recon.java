package lec_6_assignment;

import java.util.Scanner;

public class revert_arr_recon {
	private static Scanner in;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		int N = in.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
		}
		revert_arr(0, arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void revert_arr(int si, int[] arr) {
		if (si == arr.length / 2) {
			return;
		}
		int temp = arr[si];
		arr[si] = arr[arr.length - 1 - si];
		arr[arr.length - 1 - si] = temp;
		revert_arr(si+1,arr);
	}

}
