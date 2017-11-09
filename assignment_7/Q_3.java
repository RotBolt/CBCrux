package assignment_7;

public class Q_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(is_reverse("rohan","nahoR"));
	}

	public static boolean is_reverse(String str1, String str2) {
		if (str1.length() == 0 || str2.length() == 0) {
			if (str1.length() == 0 && str2.length() == 0) {
				return true;
			} else {
				return false;
			}
		}
		if (str1.charAt(str1.length() - 1) != str2.charAt(0)) {
			return false;
		} else {
			return is_reverse(str1.substring(0, str1.length() - 1), str2.substring(1));
		}
	}
}
