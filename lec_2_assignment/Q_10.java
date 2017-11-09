package lec_2_assignment;

import java.util.Scanner;

public class Q_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int total_rows;
		total_rows=in.nextInt();
		int row_no = 1;
		int no0 = 0;
		int no1 = 1;
		int no2;
		while(row_no<=total_rows){
			int no_of_elements=1;
			while(no_of_elements<=row_no){
				System.out.print(no0+"\t");
				no2=no0+no1;
				no0=no1;
				no1=no2;
				no_of_elements++;
			}
			row_no++;
			System.out.println();
		}
	}

}
