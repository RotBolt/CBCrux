package assignment_8b;

import java.util.Scanner;

public class Q_8 {

	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		int no_of_moves = in.nextInt();
		int[] moves = new int[no_of_moves];
		for (int i = 0; i < moves.length; i++) {
			moves[i] = in.nextInt();
		}
		System.out.println(snl_moves(moves, 10, 0));
	}

	public static boolean snl_moves(int[] moves, int end, int curr) {
		int[][] snl_arr = make_snl_arr(end);
		boolean ladder = true;
		for (int i = 0; i < moves.length; i++) {
			int step = moves[i];
			curr += step;
			if(curr==end){
				System.out.println("board passed in "+(i+1)+" moves");
				return true;
			}
			if (curr > end / 2) {
				ladder = false;
			} else {
				ladder = true;
			}
			if (isPrime(curr) && ladder) {
				int lpos = check(snl_arr, curr);
				if (lpos == 1) {
					int up = give_pos(snl_arr, curr);
					curr = up;
				}
			} else if (isPrime(curr) && (!ladder)) {
				int lpos = check(snl_arr, curr);
				if (lpos == 0) {
					int low = give_pos(snl_arr, curr);
					curr = low;
				}
			}
		}
		if (curr == end) {
			return true;
		} else {
			return false;
		}
	}

	static public int check(int[][] snl_arr, int curr) {
		int index = binary_search(snl_arr, curr);
		return snl_arr[index][1];
	}

	static public int binary_search(int[][] arr, int num) {
		int si = 0;
		int li = arr.length - 1;
		int mid = (si + li) / 2;
		int retval = 0;
		while (si <= li) {
			if (arr[mid][0] == num) {
				retval = mid;
				break;
			} else if (arr[mid][0] > num) {
				li = mid-1;
				mid = (si + li) / 2;
			} else {
				si = mid+1;
				mid = (si + li) / 2;
			}
		}
		return retval;
	}

	static public int[][] make_snl_arr(int end) {
		int size = give_num_primes(end);
		int[][] snl_arr = new int[size][2];
		snl_arr[0][0] = 2;
		snl_arr[0][1] = 1;
		int ri = 1;
		int val = 0;
		int num = 3;
		while (num <= end) {
			int div = 2;
			boolean flag = true;
			while (div * div <= num) {
				if (num % div == 0) {
					flag = false;
					break;
				}
				div++;
			}
			if (flag) {
				snl_arr[ri][0] = num;
				snl_arr[ri][1] = val;
				ri++;
				if (val == 0) {
					val = 1;
				} else {
					val = 0;
				}
			}
			num++;
		}
		return snl_arr;
	}

	static public int give_num_primes(int limit) {
		int num = 2;
		int count = 0;
		while (num <= limit) {
			int div = 2;
			boolean flag = true;
			while (div * div <= num) {
				if (num % div == 0) {
					flag = false;
					break;
				}
				div++;
			}
			if (flag == true) {
				count++;
			}
			num++;
		}
		return count;
	}

	static public int give_pos(int[][] snl_arr, int curr) {
		int index = binary_search(snl_arr, curr);
		int step = snl_arr[snl_arr.length - 1 - index][0];
		return step;
	}

	static public boolean isPrime(int num) {
		if (num == 0 || num == 1) {
			return false;
		}
		int div = 2;
		while (div * div <= num) {
			if (num % div == 0) {
				return false;
			}
			div++;
		}
		return true;
	}
}
