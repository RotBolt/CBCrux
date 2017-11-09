package assignment_7;

public class Q_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(is_pallindrome("abbaa"));
	}
	public static boolean is_pallindrome(String str){
		if(str.length()==1||str.length()==0){
			return true;
		}
		if(str.charAt(0)!=str.charAt(str.length()-1)){
			return false;
		}
		else{
			return is_pallindrome(str.substring(1,str.length()-1));
		}
	}

}
