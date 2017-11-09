package assignment_7;

public class Q_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         System.out.println(count_twins("axaxaxxa"));
	}
	public static int count_twins(String str){
		if(str.length()==2){
			return 0;
		}
		int count=0;
		if(str.charAt(0)==str.charAt(2)){
			count++;
		}
		count+=count_twins(str.substring(1));
		return count;
	}

}
