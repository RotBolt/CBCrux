package assignment_8b;

import java.util.ArrayList;

public class Q_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count_snl(0, 10, 10));
	}

	static public int count_snl(int curr, int end, int li) {
		if (curr == end) {
			return 1;
		}
		int count = 0;
		for (int i = 1; i <= 6; i++) {
			//to avoid extra function calls and stack
			if (curr + i > end) {
				return count;
			}
			//curr+i<end/2 bcoz after half ladder bottom portion ends
			if (isPrime(curr + i) && curr + i < end / 2) {
				int step = give_ei(li);
				li = step - 1;
				count += count_snl(step, end, li);
			} else {
				count += count_snl(curr + i, end, li);
			}
		}
		return count;
	}

	static public boolean isPrime(int num) {
		if (num == 0 || num == 1) {
			return false;
		}
		int div = 2;
		while (div * div <= num) {
			if (num % div == 0) {
				return false;
			}
			div++;
		}
		return true;
	}
	static public ArrayList<String> get_snl(int curr, int end, int li) {
		if (curr == end) {
			ArrayList<String> base=new ArrayList<>();
			base.add("");
			return base;
		}
		ArrayList<String> t_res=new ArrayList<>();
		ArrayList<String> rec_res=new ArrayList<>();
		for(int i=1;i<=6;i++){
			if(curr+i>end){
				return t_res;
			}
			if(isPrime(curr+i)&&curr+i<end/2){
				int step=give_ei(li);
				li=step-1;
				rec_res=get_snl(step,end,li);
				for(int j=0;j<rec_res.size();j++){
					t_res.add(i+rec_res.get(j));
				}
			}else{
				rec_res=get_snl(curr+i,end,li);
				for(int j=0;j<rec_res.size();j++){
					t_res.add(i+rec_res.get(j));
				}
			}
		}
		return t_res;
	}

	// gives upper end index of ladder
	static public int give_ei(int start) {
		int retval = 0;
		while (start >= start / 2) {
			if (isPrime(start)) {
				retval = start;
				break;
			}
			start--;
		}
		return retval;
	}

}
