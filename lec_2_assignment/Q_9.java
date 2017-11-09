package lec_2_assignment;

import java.util.Scanner;

public class Q_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in= new Scanner(System.in);
		int total_rows;
		total_rows=in.nextInt();
		int row_no = 0;
		while (row_no < total_rows) {
			int no_of_elements = 1;
			int col_no = 0;
			while (no_of_elements <= (row_no + 1)) {
					int r_fact=fact_calc(row_no);
					int c_fact=fact_calc(col_no);
					int r_c_fact=fact_calc(row_no-col_no);
					int value=r_fact/(c_fact*r_c_fact);
					System.out.print(value+"\t");
					no_of_elements++;
					col_no++;
			}
			System.out.println();
			row_no++;
		}
	}

	public static int fact_calc(int number) {
		int fact = 1;
		while (number != 0) {
			fact = fact * number;
			number--;
		}
		return (fact);
	}

}
