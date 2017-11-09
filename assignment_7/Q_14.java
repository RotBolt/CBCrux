package assignment_7;

public class Q_14 {
    static boolean start=false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(match("(and)nhg(rohan)",""));
	}
	public static String match(String str, String ob) {
		if(str.length()==0){
			return ob;
		}
		char cc = str.charAt(0);
		if (cc == ')') {
			start = false;
			return match(str.substring(1), ob);
		}
		if (cc == '(') {
			start = true;
			return match(str.substring(1), ob);
		}
		if (start == true) {
			return match(str.substring(1), ob + cc);
		} else {
			return match(str.substring(1), ob);
		}
	}

}
