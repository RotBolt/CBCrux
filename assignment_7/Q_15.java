package assignment_7;

public class Q_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         System.out.println(bracket("(a+{b+c}",""));
	}
	public static boolean bracket(String str, String ob) {
		// boolean check = true;
		if (str.length() == 0) {
			if (ob.length() == 0) {
				return true;
			} else
				return false;
		}
		if (str.charAt(0) == ')' || str.charAt(0) == '}' || str.charAt(0) == ']') {
			if (ob.length() != 0) {

				if (ob.charAt(ob.length() - 1) == '{' && str.charAt(0) == '}') {
					return bracket(str.substring(1), ob.substring(0, ob.length() - 1));
				} else if (ob.charAt(ob.length() - 1) == '[' && str.charAt(0) == ']') {
					return bracket(str.substring(1), ob.substring(0, ob.length() - 1));
				} else if (ob.charAt(ob.length() - 1) == '(' && str.charAt(0) == ')') {
					return bracket(str.substring(1), ob.substring(0, ob.length() - 1));
				} else {
					return false;
				}
			} else
				return false;
		}
		if (str.charAt(0) == '(' || str.charAt(0) == '{' || str.charAt(0) == '[') {
			return bracket(str.substring(1), ob + str.charAt(0));
		} else
			return bracket(str.substring(1), ob);
	}

}
