package lec_10_class;

import java.util.Scanner;

public class Quick_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
        int n= scan.nextInt();
        int []arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]= scan.nextInt();
        }
        quick_sort(arr, 0, arr.length - 1);

	}

	public static void quick_sort(int[] arr, int low, int high) {
		if (low >= high) {
			return ;
		}
		int mid = (low + high) / 2;
		int pivot = arr[mid];
		int left = low, right = high;
		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}
			while (arr[right] > pivot) {
				right--;
			}
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
				
			}
		}
		quick_sort(arr, low, right);
		quick_sort(arr, left, high);

	}

}
