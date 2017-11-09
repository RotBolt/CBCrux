package lec_5_assignment;

import java.util.Scanner;

public class max_frequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = new String();
		StringBuilder sb = new StringBuilder();
		Scanner in = new Scanner(System.in);
		str=in.next();
		char max = max_frequency(str, sb);
		System.out.println(max);
	}

	public static char max_frequency(String str,StringBuilder sb) {
		char max_c = 'a';
		int max_f = 0;
		int index = 0;
		while (index != str.length()) {
			char ch=str.charAt(index);
			boolean check = registry(sb,ch);
			if (check == true)
				index++;
			else {
				char letter = str.charAt(index);
				int f = 0;
				for (int i = 0; i < str.length(); i++) {
					if (letter == str.charAt(i))
						f++;
				}
				if (f > max_f) {
					max_f = f;
					max_c = letter;
				}
				index++;
			}
		}
		return max_c;
	}

	public static boolean registry(StringBuilder sb,char letter) {
		for (int i = 0; i < sb.length(); i++) {
			if (letter == sb.charAt(i))
				return true;
		}
		sb.append(letter);
		return false;
	}
}
