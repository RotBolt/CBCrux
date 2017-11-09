package assignment_7;

public class Q_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		num_to_alpha("1123", "");
	}

	public static void num_to_alpha(String str, String res) {
		if (str.length() == 0) {
			System.out.println(res);
			return;
		}
		num_to_alpha(str.substring(0, str.length() - 1), ((char) (str.charAt(str.length() - 1) + 48)) + res);
		if (str.length() == 1) {
			return;
		}
		char c1 = str.charAt(str.length() - 1);
		char c2 = str.charAt(str.length() - 2);
		// to check whether the one's place> 6 as there are 26 alphabets
		
		// to check whether ten's place is greater than 2 as there are 26
		// alphabets
		if (c1 - 48 > 6 && c2 - 48 > 2) {
			return;
		}
		
		int num = 9 * (c2 - 48);
		// to convert two digit in alphabet
		char ch = (char) (c1 + c2 + num);
		num_to_alpha(str.substring(0, str.length() - 2), ch + res);
	}

}
