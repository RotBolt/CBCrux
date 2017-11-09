package lec_4_class;

public class mirror_inverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 3, 1, 0 };
		int size = 4;

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.print("\n*******************************\n");
		boolean result = Mirror_inverse(arr,size);
		if (result == true)
			System.out.println("The no is mirror inverse");
		else
			System.out.println("The no is not  mirror inverse");
	}

	public static boolean Mirror_inverse(int[] arr, int size) {
		int[] arr2 = new int[size];
		int num;
		for (int i = 0; i < arr.length; i++) {
			num = arr[i];
			arr2[num] = i;
		}
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i]+"\t");
		}
		System.out.println("\n*******************************");
		for (int i = 0; i < size; i++) {
			if (arr[i] != arr2[i]) {
				return (false);
			}
		}
		return (true);

	}

}
