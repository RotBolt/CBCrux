package assignment_8a;

import java.util.ArrayList;

public class Q_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(get_num_pad("28"));
		// prin_num_pad("12","");
	}

	public static ArrayList<String> get_num_pad(String str) {
		if (str.length() == 0) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		char cc = str.charAt(0);
		int inc = 48 + 2 * (str.charAt(0) - 49);
		ArrayList<String> total_res = new ArrayList<>();
		ArrayList<String> rec_res = null;
		rec_res = get_num_pad(str.substring(1));
		if (str.charAt(0) == '9') {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < rec_res.size(); j++)
					total_res.add((char) (cc + inc + i) + rec_res.get(j));
			}
			return total_res;
		} else {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < rec_res.size(); j++)
					total_res.add((char) (cc + inc + i) + rec_res.get(j));
			}
			return total_res;
		}
	}

	public static void prin_num_pad(String str, String res) {
		if (str.length() == 0) {
			System.out.println(res);
			return;
		}
		char cc = str.charAt(0);
		int inc = 48 + 2 * (str.charAt(0) - 49);
		for (int i = 0; i < 3; i++) {
			prin_num_pad(str.substring(1), res + (char) (cc + inc + i));
		}
	}

	public static int count_num_pad(String str) {
		if (str.length() == 0) {
			return 1;
		}
		int retval = 3 * count_num_pad(str.substring(1));
		return retval;
	}

}
