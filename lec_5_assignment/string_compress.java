package lec_5_assignment;

import java.util.Scanner;

public class string_compress {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = new String();
		str = in.next();
		String compressed = string_compress(str);
		System.out.println(compressed);

	}

	public static String string_compress(String str) {
		StringBuilder sb = new StringBuilder();
		int index = 0;
		int counter = 0;
		char letter = str.charAt(0);
		while (counter < str.length()) {
			int aplha_count = 0;
			for (int i = index; i < str.length(); i++) {
				if (letter != str.charAt(i)) {
					index = i;
					break;
				}
				counter++;
				aplha_count++;
			}
			sb.append(letter);
			if (aplha_count > 1)
				sb.append(aplha_count);
			letter = str.charAt(index);
		}
		return sb.toString();
	}

}
