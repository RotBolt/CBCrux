package lec_7_class;

import java.util.ArrayList;
import java.util.Collections;

public class recon_beta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList<String> ans = getbp(10, 0);
		//System.out.println(ans + "\n" + ans.size());
		// prinbp(10,0,"");
		System.out.println(getbp(10,0));
//		ArrayList<String> res=getperm("abc");
//		Collections.sort(res);
//		System.out.println(res);
		//prinPerm("abc", "");

	}

	public static ArrayList<String> getSS(String str) {
		if (str.length() == 0) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		char cc = str.charAt(0);
		int ascii = cc;
		String sub = str.substring(1);
		ArrayList<String> myresult = new ArrayList<>();
		ArrayList<String> recresult = getSS(sub);
		for (int i = 0; i < recresult.size(); i++) {
			myresult.add(recresult.get(i));
			myresult.add(cc + recresult.get(i));
			myresult.add(ascii + recresult.get(i));
		}
		return myresult;
	}

	public static ArrayList<String> getperm(String str) {
		if (str.length() == 0) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		char cc = str.charAt(0);
		String sub = str.substring(1);
		ArrayList<String> myresult = new ArrayList<>();
		ArrayList<String> recresult = getperm(sub);
		for (int i = 0; i < recresult.size(); i++) {
			String recStr = recresult.get(i);
			for (int j = 0; j <= recStr.length(); j++) {
				String mystring = recStr.substring(0, j) + cc + recStr.substring(j);
				myresult.add(mystring);
			}
		}
		return myresult;

	}

	public static ArrayList<String> getbp(int end, int curr) {
		if (curr == end) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
//		if (curr == 7) {
//			ArrayList<String> base = new ArrayList<>();
//			return base;
//		}
		if (curr > end) {
			ArrayList<String> base = new ArrayList<>();
			return base;
		}
		ArrayList<String> myresult = new ArrayList<>();
		ArrayList<String> recresult = null;
		for (int i = 1; i <= 6; i++) {
			recresult = getbp(end, curr + i);
			for (int k = 0; k < recresult.size(); k++) {
				myresult.add(i + recresult.get(k));
			}

		}
		return myresult;

	}

	public static void prinSS(String str, String result) {
		if (str.length() == 0) {
			System.out.println(result);
			return;
		}

		prinSS(str.substring(1), result + str.charAt(0));
		prinSS(str.substring(1), result);

	}

	public static void prinSSAscii(String str, String result) {
		if (str.length() == 0) {
			System.out.println(result);
			return;
		}
		prinSSAscii(str.substring(1), result);
		prinSSAscii(str.substring(1), result + str.charAt(0));
		prinSSAscii(str.substring(1), result + (int) (str.charAt(0)));
		// prinSS(str.substring(1),result);

	}

	public static void prinPerm(String str, String result) {
		if (str.length() == 0) {
			System.out.println(result);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);
			String sstring = str.substring(0, i) + str.substring(i + 1);
			prinPerm(sstring, result + cc);
		}
	}

	public static void prinbp(int end, int curr, String path) {
		if (curr == end) {
			System.out.println(path);
			return;
		}
		if (curr > end) {
			return;
		}
		for (int i = 1; i <= 6; i++) {
			prinbp(end, curr + i, path + i);
		}
	}
}
