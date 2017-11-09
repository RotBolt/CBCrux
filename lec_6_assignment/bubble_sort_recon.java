package lec_6_assignment;

import java.util.Scanner;

public class bubble_sort_recon {

	private static Scanner in;
	public static void main(String[] args) {
		in = new Scanner (System.in);
		int n=in.nextInt();
		int [] arr = new int [n];
		for(int i=0;i<arr.length;i++){
			arr[i]=in.nextInt();
		}
		bubble_sort(0,arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}

	}
	public static void bubble_sort(int si, int [] arr){
		
		for(int i=si;i<arr.length-1;i++){
			if(arr[si]>arr[si+1]){
				int temp=arr[si];
				arr[si]=arr[si+1];
				arr[si+1]=temp;
			}
			if(si+1==arr.length-1){
				return;
			}
			bubble_sort(si+1,arr);
			if(arr[si]<arr[si+1]){
				return;
			}
		}
	}

}
