package lec_6_assignment;

import java.util.Scanner;

public class inverse_arr_recon {
	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		int N = in.nextInt();
		int[] arr = new int[N];
		int[] res = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
		}
		invert_arr(0, arr, res);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}

	}

	public static void invert_arr(int si, int[] arr, int[] res) {
		if (si == arr.length) {
			return;
		}
		int val = arr[si];
		res[val] = si;
		invert_arr(si + 1, arr, res);
	}

}
