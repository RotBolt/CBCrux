package lec_4_class;

public class inverse_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 3, 1, 0 };
		int size = 4;
		int[] arr2 = inverse(arr, size);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("*******************");
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
	}

	public static int[] inverse(int[] arr, int size) {
		int[] arr2 = new int[size];
		int num;
		for (int i = 0; i < arr.length; i++) {
			num = arr[i];
			arr2[num] = i;
		}
		return (arr2);
	}
}
