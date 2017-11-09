package lec_4_assignment;

public class permute_arr_attempt_2 {
	static int maity = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		permute_arr(arr);
	}

	public static void swap(int[] arr, int left, int right) {
		int temp = arr[right];
		arr[right] = arr[left];
		arr[left] = temp;
	}

	/*
	 * for creating sub_array if array {1,2,3,4,5} then sub array woud be
	 * {2,3,4,5}
	 * 
	 * algo used is simple fix first position and swap adjacent places in sub
	 * arr after completing sub array
	 * 
	 * swap 1 with 2 then array would be {2,1,3,4,5}
	 * 
	 * again fix first position and permute sub arr
	 */
	public static int[] sub_arr_maker(int[] arr) {

		int[] sub_arr = new int[arr.length - 1];
		for (int k = 1; k < arr.length; k++) {
			sub_arr[k - 1] = arr[k];
		}
		return sub_arr;
	}

	public static void permute_arr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			swap(arr, 0, i);
			int[] sub_arr = sub_arr_maker(arr);
			int fact = factorial(sub_arr.length);
			// for getting number to run loop (for loop below)
			int left = 0;
			int right = left + 1;

			// left and right are markers for swapping places
			for (int j = 0; j < fact; j++) {
				display(arr[0], sub_arr);
				swap(sub_arr, left, right);
				left = left + 1;
				right = right + 1;

				// critical conditions
				if (right > sub_arr.length - 1)
					right = 0;
				if (left > sub_arr.length - 1) {
					left = 0;
					right = left + 1;
				}
			}
		}
	}

	public static void display(int first, int[] sub) {

		System.out.print(first + "  ");
		for (int k = 0; k < sub.length; k++) {
			System.out.print(sub[k] + "  ");
		}
		System.out.print(++maity);
		System.out.println();

	}

	public static int factorial(int num) {
		int fact = 1;
		while (num > 0) {
			fact *= num;
			num--;
		}
		return fact;
	}
}
