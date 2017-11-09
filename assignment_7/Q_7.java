package assignment_7;

public class Q_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(append_X_last_recon("aaxcdshxxmn", ""));
	}

	public static String append_X_last(String str) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != 'x') {
				sb.append(str.charAt(i));
			} else {
				count++;
			}
		}
		while (count > 0) {
			sb.append('x');
			count--;
		}
		return sb.toString();
	}

	public static String append_X_last_recon(String str, String res) {
		if (str.length() == 0) {
			return res;
		}
		int count = 0;
		String result = new String();
		if (str.charAt(0) != 'x') {
			result = append_X_last_recon(str.substring(1), res + str.charAt(0));
		} else {
			count++;
			result = append_X_last_recon(str.substring(1), res);
		}
		if (count == 1) {
			return (result + "x");
		} else {
			return (result);
		}
	}

}
