package lec_5_assignment;

import java.util.Scanner;

public class remove_duplicates {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = new String();
		Scanner in =new Scanner(System.in);
		str=in.next();
		String result = rem_dupli(str);
		System.out.println(result);
	}

	public static String rem_dupli(String str) {
		StringBuilder sb = new StringBuilder();
		int counter = 0;
		int index = 0;
		while (counter < str.length()) {
			char letter=str.charAt(index);
			if(counter==str.length()-1){
				counter++;
				if(sb.charAt(sb.length()-1)==letter)// as it was appending two times last
					break;
			}
			sb.append(letter);
			for (int i = index + 1; i < str.length(); i++) {
				counter++;
				if (letter != str.charAt(i)) {
					index = i;
					break;
				}
			}
		}
		return sb.toString();
	}
}
