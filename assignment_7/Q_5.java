package assignment_7;

public class Q_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(separate("helllllo", ""));
	}

	public static String separate(String str, String res) {
		if (str.length() == 1) {
			return res + str.charAt(0);
		}
		if (str.charAt(0) == str.charAt(1)) {
			return separate(str.substring(1), res + str.charAt(0) + "*");
		} else {
			return separate(str.substring(1), res + str.charAt(0));
		}
	}
}
