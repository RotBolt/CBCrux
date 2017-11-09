package lec_4_assignment;

public class permute_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5 };
		int[] orig_arr = new int[arr.length];
		int[] reg_arr = new int[arr.length];
		for (int k = 0; k < arr.length; k++) {
			orig_arr[k] = arr[k];
		}
		Permute_array(arr, 0, reg_arr);

	}

	public static void Permute_array(int[] arr, int index, int[] reg_arr) {
		index = index + 1;
		int i;
		if (index == arr.length) {
			display(arr);
			return;
		} else {
			for (i = index; i <= arr.length; i++) {
				if (i == arr.length && index == 1) {
					int t_index = place_index(arr, reg_arr);
					int temp = arr[t_index];
					arr[t_index] = arr[0];
					arr[0] = temp;
				}
				Permute_array(arr, index, reg_arr);
				if (index == 1)
					register_arr(reg_arr, arr[0]);
				swap(arr, index);
			}
		}
		swap(arr, index);
		/*
		 * boolean check = equal_arr(orig_arr, arr); if (check == true) { int
		 * temp = arr[arr.length - 1]; arr[arr.length - 1] = arr[0]; arr[0] =
		 * temp; }
		 */
	}

	public static void swap(int[] arr, int index) {
		int temp = arr[index];
		arr[index] = arr[index - 1];
		arr[index - 1] = temp;
	}

	public static boolean equal_arr(int[] orig_arr, int[] arr) {
		for (int k = 0; k < arr.length; k++) {
			if (orig_arr[k] != arr[k])
				return false;
		}
		return true;
	}

	public static void display(int[] arr) {
		for (int k = 0; k < arr.length; k++) {
			System.out.print(arr[k] + "   ");
		}
		System.out.println();
	}

	public static void register_arr(int[] reg_arr, int value) {
		for (int k = 0; k < reg_arr.length; k++) {
			if (reg_arr[k] == 0) {
				reg_arr[k] = value;
				return;
			}
		}
	}

	public static int place_index(int[] arr, int[] reg_arr) {
		int last = 0;
		for (int k = 0; k < arr.length; k++) {
			int flag = 0;
			for (int l = 0; l < reg_arr.length; l++) {
				if (arr[k] == reg_arr[l]) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				last = k;
				break;
			}
		}

		return last;
	}
}
