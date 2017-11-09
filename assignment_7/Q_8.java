package assignment_7;

public class Q_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(func("abhikanihi",""));
	}
	public static String func(String str, String res){
		// this case is general case
		if(str.length()==1){
			return res+str.charAt(0);
		}
		/*this case hits when hi is at the last*/
		if(str.length()==0){
			return res;
		}
		if(str.substring(0,2).equals("hi")){
			return func(str.substring(2),res);
		}
		else{
			return func(str.substring(1),res+str.charAt(0));
		}
	}
	public static int count_hi(String str){
		
		if(str.length()==1){
			return 0;
		}
		int count=0;
		if(str.substring(0,2).equals("hi")){
			count++;
			count+=count_hi(str.substring(1));
		}
		else{
			count+= count_hi(str.substring(1));
		}
		return count;
	}
	public static String func_bye(String str, String res){
		if(str.length()==1){
			return res+str.charAt(0);
		}
		if(str.length()==0){
			return res;
		}
		if(str.substring(0,2).equals("hi")){
			return func_bye(str.substring(2),res+"bye");
		}
		else{
			return func_bye(str.substring(1),res+str.charAt(0));
		}
	}

}
