package lec_4_class;

public class doublets_sum_array { //also triplets

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 5, 6, 3, 1, 8, 0, 7 };
		whose_sum_is(arr, 9);
	}

	public static void whose_sum_is(int[] arr, int sum) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				for (int z = j; z < arr.length; z++) {
					if (arr[i] + arr[j] + arr[z]== sum)
						System.out.println(arr[i] + " + " + arr[j] + " + " + arr[z] + " = " + sum);
				}

			}
		}
	}
}
