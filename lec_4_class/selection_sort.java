package lec_4_class;

public class selection_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {60,40,80,70,20};
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println("\n**************************");
		selection_sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}

	public static void selection_sort(int[] arr) {
		
		for (int i = 0; i < arr.length - 1; i++) {
			int min_index=i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min_index] > arr[j]) {
					
					min_index=j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min_index];
			arr[min_index] = temp;

		}
	}
}
