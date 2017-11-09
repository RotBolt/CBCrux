package lec_2_assignment;

public class Q_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total_rows = 4;
		int row_no = 1;
		int value = 0;
		while (row_no <= total_rows) {
			int space_counter = 1;
			int col_no = 1;
			while (space_counter <= (total_rows - row_no)) {
				System.out.print("\t");
				space_counter++;
				col_no++;
			}
			int no_of_elements = 1;
			int increaser = 0;
			int decreaser = 1;
			while(no_of_elements<=(2*row_no-1)){
				if(col_no<=total_rows){
					value=row_no+increaser;
					System.out.print(value+"\t");
					increaser++;
					col_no++;
				}
				else{
					System.out.print((value-decreaser)+"\t");
					decreaser++;
				}
				no_of_elements++;
			}
			row_no++;
			System.out.println();
		}
	}

}
