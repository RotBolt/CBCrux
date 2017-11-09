/**
 * 
 */
package assignment_8a;

import java.util.ArrayList;

/**
 * @author rohn_dragneel
 *
 */
public class Q_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       //prin_perm("abc","");
		System.out.println(count_perm("abc",1));
	}
	public static ArrayList<String> get_perm(String str){
		if(str.length()==0){
			ArrayList<String> base= new ArrayList<>();
			base.add("");
			return base;
		}
		char cc=str.charAt(0);
		ArrayList<String> f_res=new ArrayList<>();
		ArrayList<String> rec_res=get_perm(str.substring(1));
		for(int i=0;i<rec_res.size();i++){
			String rec_str=rec_res.get(i);
			for(int j=0;j<=rec_str.length();j++){
				String sub=rec_str.substring(0, j)+cc+rec_str.substring(j);
				f_res.add(sub);
			}
		}
		return f_res;
	}
	public static void prin_perm(String str, String res){
		if(str.length()==0){
			System.out.println(res);
			return;
		}
		for(int i=0;i<str.length();i++){
			char cc= str.charAt(i);
			String sub=str.substring(0, i)+str.substring(i+1);
			prin_perm(sub,res+cc);
		}
	}
	public static int count_perm(String str,int val){
		if(str.length()==0){
			return val;
		}
		int retval=str.length();
		retval*=val;
		int f_res=count_perm(str.substring(1),retval);
		return f_res;
		
	}

}
