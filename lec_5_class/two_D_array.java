package lec_5_class;

import java.util.Scanner;

public class two_D_array {

	static Scanner in;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int[][] arr=take_input();
		 * System.out.println("\n****************************88"); display(arr);
		 * System.out.println("\n****************************88");
		 * wave_print(arr); wave_print_column(arr);
		 */
		in = new Scanner(System.in);
		int rows = in.nextInt();
		int cols = in.nextInt();
		int[][] arr = new int[rows][cols];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[rows - 1].length; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		anti_spiral_print(arr);
		/*
		 * Scanner in = new Scanner(System.in); String sb = new String(); sb =
		 * in.next(); String result = insert_difference(sb);
		 * System.out.println(result);
		 */
	}

	public static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static int[][] take_input() {
		in = new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int rows = in.nextInt();
		int[][] retval = new int[rows][];
		for (int row_no = 0; row_no < retval.length; row_no++) {
			System.out.println("Enter the no of columns for " + row_no + "th row ");
			int cols = in.nextInt();
			retval[row_no] = new int[cols];
			for (int col_no = 0; col_no < retval[row_no].length; col_no++) {
				System.out.println("Enter the data for " + row_no + "th row and " + col_no + "th column");
				retval[row_no][col_no] = in.nextInt();
			}
		}
		return (retval);
	}

	public static void wave_print(int[][] arr) {
		for (int row_no = 0; row_no < arr.length; row_no++) {
			if (row_no % 2 == 0) {
				for (int col_no = 0; col_no < arr[row_no].length; col_no++) {
					System.out.print(arr[row_no][col_no] + "\t");
				}
			} else {
				for (int col_no = arr[row_no].length - 1; col_no > 0; col_no--) {
					System.out.print(arr[row_no][col_no] + "\t");
				}
			}
			System.out.println();
		}
	}

	public static void wave_print_column(int[][] arr) {
		for (int col_no = 0; col_no < arr.length; col_no++) {
			if (col_no % 2 == 0) {
				for (int row_no = 0; row_no < arr.length; row_no++) {
					System.out.print(arr[row_no][col_no] + "\t");
				}
			} else {
				for (int row_no = arr.length - 1; row_no > 0; row_no--) {
					System.out.print(arr[row_no][col_no] + "\t");
				}
			}
		}
	}

	public static void spiral_print(int[][] arr) {
		int left = 0;
		int right = arr[0].length - 1;
		int top = 0;
		int bottom = arr.length - 1;
		int dir = 1;
		while (left < right && top <= bottom) {
			if (dir == 1) {
				for (int i = left; i <= right; i++) {
					System.out.print(arr[top][i] + " ");
				}
				dir = 2;
				top++;
			}

			if (dir == 2) {
				for (int i = top; i <= bottom; i++) {
					System.out.print(arr[i][right] + " ");
				}
				dir = 3;
				right--;
			}
			if (top <= bottom) {
				if (dir == 3) {
					for (int i = right; i >= left; i--) {
						System.out.print(arr[bottom][i] + " ");
					}
					dir = 4;
					bottom--;
				}
			}

			if (dir == 4) {
				for (int i = bottom; i >= top; i--) {
					System.out.print(arr[i][left] + " ");
				}
				left++;
				dir = 1;
			}

		}
	}

	public static void anti_spiral_print(int[][] arr) {
		int left = 0;
		int right = arr[0].length - 1;
		int top = 0;
		int bottom = arr.length - 1;
		int dir = 1;
		while (left <= right && top <= bottom) {

			if (dir == 1) {
				for (int i = top; i <= bottom; i++) {
					System.out.print(arr[i][left] + " ");
				}
				dir = 2;
				left++;
			}

			if (dir == 2) {
				for (int i = left; i <= right; i++) {
					System.out.print(arr[bottom][i] + " ");
				}
				dir = 3;
				bottom--;
			}
			if (dir == 3) {
				for (int i = bottom; i >= top; i--) {
					System.out.print(arr[i][right] + " ");
				}
				right--;
				dir = 4;
			}
			if (top <= bottom) {
				if (dir == 4) {
					for (int i = right; i >= left; i--) {
						System.out.print(arr[top][i] + " ");
					}
					dir = 1;
					top++;
				}
			}

		}
	}

	public static String toggle(StringBuilder sb) {
		for (int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);
			if ((i + 1) % 2 == 0) {
				ch = (char) (ch - 1);
				sb.setCharAt(i, ch);
			} else {
				ch = (char) (ch + 1);
				sb.setCharAt(i, ch);
			}

		}
		String result = sb.toString();
		return result;
	}

	public static String insert_difference(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i));
		}

		for (int i = 0; i < sb.length() - 1; i += 2) {
			int dif = sb.charAt(i + 1) - sb.charAt(i);
			char num = (char) (dif + 48);
			char last = sb.charAt(sb.length() - 1);
			sb.append(last);
			for (int j = sb.length() - 2; j > i; j--) {
				char ch = sb.charAt(j - 1);
				sb.setCharAt(j, ch);
			}
			sb.setCharAt(i + 1, num);
		}
		// System.out.println(sb.length());
		String result = sb.toString();
		return result;
	}

	public static String insert_ascii(String str) {
		StringBuilder sb = new StringBuilder();
		char prev = str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			char cc = str.charAt(i);
			sb.append(prev);
			sb.append(cc - prev);
			prev = cc;
		}
		sb.append(prev);
		return sb.toString();
	}

	public static String oddeven(String s) {
		StringBuilder r = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if ((i + 1) % 2 == 0) {
				char ch = s.charAt(i);
				ch = (char) (ch - 1);
				r.append(ch);
			} else {
				char ch = s.charAt(i);
				ch = (char) (ch + 1);
				r.append(ch);
			}
		}
		return r.toString();
	}
}
