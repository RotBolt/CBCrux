package lec_4_class;

public class bubble_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 20, 10, 60, 70, 40, 80 };
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println("\n**************************");
		bubble_sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}

	public static void bubble_sort(int[] arr) {
		for (int i = arr.length; i > 0; i--) {
			for (int j = 0; j < i-1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
	}
}
