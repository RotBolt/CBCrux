package lec_2_assignment;

public class Q_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total_rows = 4;
		int row_no=0;
		while(row_no<total_rows){
			int no_of_elements=1;
			int value=0;
			while(no_of_elements<=(row_no+1)){
				value++;
				System.out.print(value+"\t");
				no_of_elements++;
			}
			no_of_elements=1;
			int total_spaces=2*total_rows-3-2*row_no;
			while(no_of_elements<=total_spaces){
				System.out.print("\t");
				no_of_elements++;
			}
			if(total_spaces<=0) value=value-1;
			no_of_elements=1;
			while(no_of_elements<=(row_no+1)){
				if(value>0)System.out.print(value+"\t");
				value--;
				no_of_elements++;
			}
			System.out.println();
			row_no++;
		}
	}

}
