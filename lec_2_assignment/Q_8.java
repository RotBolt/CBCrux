package lec_2_assignment;

public class Q_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total_rows=6;
		int row_no = 2;
		System.out.print("1\n");
		while (row_no <= total_rows) {
			System.out.print(row_no + "\t");
			int total_0 = row_no - 2;
			int counter = 1;
			while (counter <= total_0) {
				System.out.print("0\t");
				counter++;
			}
			System.out.print(row_no + "\n");
			row_no++;
		}
	}

}
