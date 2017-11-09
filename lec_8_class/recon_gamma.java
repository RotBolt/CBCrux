package lec_8_class;

public class recon_gamma {
	static boolean start = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(match("abc(def)xys", ""));
		lexico(10, 0);

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

	public static String match(String str, String ob) {
		char cc = str.charAt(0);
		if (cc == ')') {
			start = false;
			return ob;
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

	public static void lexico(int end, int curr) {

		if (curr > end) {
			return;
		}
		System.out.println(curr);
		if (curr == 0) {
			for (int i = 1; i <= 9; i++) {
				lexico(end, curr * 10 + i);
			}
		} else {
			for (int i = 0; i <= 9; i++) {
				lexico(end, curr * 10 + i);
			}
		}
	}

	public static void smaller_lexico(String str, String res, String orig, boolean issmall) {
		if (str.length() == 0) {
			if (!res.equals(orig)) {
				System.out.println(res);
			}
			return;
		}
		for (int i = 0; i < str.length();i++) {
			char cc = str.charAt(i);
			if (issmall){
				String ros=str.substring(0, i)+str.substring(i+1);
				smaller_lexico(ros,res+cc,orig,issmall);

			} else {
				if(cc<=str.charAt(0)){
				String ros = str.substring(0, i) + str.substring(i + 1);
				smaller_lexico(ros, res + cc,orig,cc<str.charAt(0));
				}
			}
		}
	}

}
