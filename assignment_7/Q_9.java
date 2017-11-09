package assignment_7;

public class Q_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(replace_hi_beta("abhihithihithi",""));
	}

	public static int count_hi_beta(String str) {
		if (str.length() == 1) {
			return 0;
		}
		int count = 0;
		if (str.substring(0, 2).equals("hi")) {
			/*this case hits when hi is at the last*/
			if (str.substring(1).length()==1) {
				return 1;
			} else if (str.substring(0, 3).equals("hit")) {
				count += count_hi_beta(str.substring(1));
			} else {
				count++;
				count += count_hi_beta(str.substring(1));
			}
		} else {
			count += count_hi_beta(str.substring(1));
		}
		return count;

	}

	public static String remove_hi_beta(String str, String res) {
		// this case is general case
		if (str.length() == 1) {
			return res + str.charAt(0);
		}
		/*this case hits when hi is at the last*/
		if (str.length() == 0) {
			return res;
		}
		if (str.substring(0, 2).equals("hi")) {
			if (str.substring(1).length() == 1) {
				return remove_hi_beta(str.substring(2), res);
			} else if (str.substring(0, 3).equals("hit")) {
				return remove_hi_beta(str.substring(1), res + str.charAt(0));
			} else {
				return remove_hi_beta(str.substring(2), res);
			}
		} else {
			return remove_hi_beta(str.substring(1), res + str.charAt(0));
		}
	}
	public static String replace_hi_beta(String str, String res) {
		// this case is general case
		if (str.length() == 1) {
			return res + str.charAt(0);
		}
		/*this case hits when hi is at the last*/
		if (str.length() == 0) {
			return res;
		}
		if (str.substring(0, 2).equals("hi")) {
			if (str.substring(1).length() == 1) {
				return replace_hi_beta(str.substring(2), res+"bye");
			} else if (str.substring(0, 3).equals("hit")) {
				return replace_hi_beta(str.substring(1), res + str.charAt(0));
			} else {
				return replace_hi_beta(str.substring(2), res+"bye");
			}
		} else {
			return replace_hi_beta(str.substring(1), res + str.charAt(0));
		}
	}

}
