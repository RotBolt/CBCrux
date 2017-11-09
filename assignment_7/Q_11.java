package assignment_7;

public class Q_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(triple_a_no_overlap("baaaabaaa"));
	}
	public static int triple_a(String str){
		if(str.length()==2){
			return 0;
		}
		int count=0;
		if(str.charAt(0)=='a'){
			if(str.substring(0, 3).equals("aaa")){
				count++;
			}
		}
		count+=triple_a(str.substring(1));
		return count;
	}
	public static int triple_a_no_overlap(String str){
		if(str.length()==2||str.length()==0){
			return 0;
		}
		int count=0;
		if(str.charAt(0)=='a'){
			if(str.substring(0, 3).equals("aaa")){
				count++;
				count+=triple_a_no_overlap(str.substring(3));
			}
			else{
				count+=triple_a_no_overlap(str.substring(1));
				}
		}
		else{
		count+=triple_a_no_overlap(str.substring(1));
		}
		return count;
	}

}
