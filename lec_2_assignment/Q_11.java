package lec_2_assignment;

public class Q_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total_rows = 5;
		int mid_row = total_rows / 2 + 1;
		int row_no=1;
		int flag=1;
		while(row_no<=mid_row){
			int space_counter=1;
			while(space_counter<=(mid_row-row_no)){
				System.out.print("\t");
				space_counter++;
			}
			int star_counter=1;
			while(star_counter<=(2*row_no-1)){
				System.out.print("*\t");
				star_counter++;
			}
			if(row_no==mid_row)flag=0;
			if(flag==1)row_no++;
			if(flag==0)row_no--;
			if(row_no==0)return;
			System.out.println();
		}
	}

}
