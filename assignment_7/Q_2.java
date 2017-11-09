package assignment_7;

public class Q_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.out.println(str_to_num("12897"));
	}
	public static int str_to_num(String str){
		if(str.length()==0){
			return 0;
		}
		int fnum=0;
		int num=(int)(str.charAt(0)-48);
		int multiplier=get_multiplier(str.substring(1).length());
		fnum+=num*multiplier+str_to_num(str.substring(1));
		return fnum;
	}
	public static int get_multiplier(int length){
		if(length==0){
			return 1;
		}
		return 10*get_multiplier(length-1);
	}

}
