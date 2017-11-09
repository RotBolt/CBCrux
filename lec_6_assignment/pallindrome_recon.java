package lec_6_assignment;

import java.util.Scanner;

public class pallindrome_recon {
	private static Scanner in;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		int N = in.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println(ISpallindrome(0, arr));

	}

	public static boolean ISpallindrome(int si, int[] arr) {
		boolean check = false;
		if (si == arr.length / 2) {
			return true;
		}
		if (arr[si] == arr[arr.length - 1 - si]) {
			check = ISpallindrome(si + 1, arr);
		} else {
			return false;
		}
		return check;
	}

}
