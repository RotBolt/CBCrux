package lec_5_class;

public class string_operations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String str = "hello";
		//ll_substrings(str);
		//int count_p_str=pallindrome_substrings_count(str);
		//System.out.println("count is "+ count_p_str);
		StringBuilder sb= new StringBuilder("helLo") ;
		String result=toggle(sb);
		System.out.println(result);
	}

	public static void all_substrings(String str) {
		for (int i = 0; i <str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				System.out.println(str.substring(i, j));
			}
		}
	}
	public static boolean pallindrome(String str){
		for (int i = 0,j=str.length()-1; i <str.length()&&j>=0; i++,j--){
			if(!(str.charAt(i)==str.charAt(j)))
				return false;
		}
		return true;
	}
	public static int pallindrome_substrings_count(String str) {
		int count=0;
		for (int i = 0; i <str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				String str1= str.substring(i, j);
				boolean result =pallindrome(str1);
				if(result==true){
					System.out.println(str1);
					count++;
				}
			}
		}
		return count;
	}
	public static String toggle(StringBuilder sb){
		for(int i=0;i<sb.length();i++){
			char ch=sb.charAt(i);
			int chnum=ch;
			if(chnum>=65&&chnum<=90){
				ch=(char)(ch+32);
				sb.setCharAt(i,ch);
			}
			if(chnum>=97&&chnum<=122){
				ch=(char)(ch-32);
				sb.setCharAt(i,ch);
			}
		}
		String result= sb.toString();
		return result;
	}
}
