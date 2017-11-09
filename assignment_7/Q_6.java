package assignment_7;

public class Q_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reduced_to_single("hhhhelllllo0ooooo", ""));
	}

	public static String reduced_to_single(String str, String res) {
		if (str.length() == 1) {
			return res + str.charAt(0);
		}
		if (str.charAt(0) != str.charAt(1)) {
			return reduced_to_single(str.substring(1), res + str.charAt(0));
		} else {
			return reduced_to_single(str.substring(1), res);
		}
	}
}
