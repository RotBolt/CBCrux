package lec_2_assignment;

public class Q_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total_rows = 5;
		int mid_row = total_rows / 2 + 1;
		int row_no=0;
		boolean direction=true;
		while(row_no<mid_row){
			int star_counter=1;
			while(star_counter<=(mid_row-row_no)){
				if(star_counter==(mid_row-row_no))System.out.print("*");
				else System.out.print("*\t");
				star_counter++;
			}
			int space_counter=1;
			while(space_counter<=(2*row_no+1)){
				System.out.print("\t");
				space_counter++;
			}
			star_counter=1;
			while(star_counter<=(mid_row-row_no)){
				System.out.print("*\t");
				star_counter++;
			}
			if(row_no==(mid_row-1)) direction=false;
			if(direction==true) row_no++;
			if(direction==false) row_no--;
			if(row_no<0)return;
			System.out.println();
		}
	}

}
