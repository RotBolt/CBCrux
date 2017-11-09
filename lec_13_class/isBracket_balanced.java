package lec_13_class;
import lec_11_class.Stack_Arrays;
public class isBracket_balanced {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        System.out.println(isBracket_balanced("(a]"));
	}
	// fails at "a+(b+c}"
	public static boolean isBracket_balanced(String str) throws Exception{
		Stack_Arrays s=new Stack_Arrays();
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='('||str.charAt(i)=='{'||str.charAt(i)=='['){
				s.push(str.charAt(i));
			}
		}
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==')'||str.charAt(i)=='}'||str.charAt(i)==']'){
				if(s.size()==0){
					return false;
				}
				s.pop();
			}
		}
		if(s.size()==0){
			return true;
		}else{
			return false;
		}
	}

}
