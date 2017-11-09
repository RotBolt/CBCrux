package lec_2_assignment;

public class Q_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total_rows = 4;
		int row_no = 1;
		int value = 0;
		boolean direction=true;
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
			if(row_no==total_rows) direction=false;
			if(direction==true)row_no++;
			if(direction==false)row_no--;
			if(row_no==0) return;
			System.out.println();
		}
	}

}
