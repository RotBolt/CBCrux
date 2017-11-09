package assignment_7;

public class Q_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abbabb";
		System.out.println(check_string(str, str.length()));
	}

	public static boolean check_string(String str, int length) {
		// just for checking first char of original string
		if (str.length() == length) {
			if (str.charAt(0) != 'a') {
				return false;
			}
		}
		if (str.charAt(0) == 'a') {
			// base case
			if (str.length() == 1) {
				return true;
			}
			if (str.charAt(1) != 'a' && !(str.substring(1, 3)).equals("bb")) {
				return false;
			} else {
				return check_string(str.substring(1), length);
			}
		}
		if (str.substring(0, 2).equals("bb")) {
			// base case
			if (str.length() == 2) {
				return true;
			}
			if (str.charAt(2) != 'a') {
				return false;
			} else {
				return check_string(str.substring(2), length);
			}
		} else {
			return false;
		}
	}

}
