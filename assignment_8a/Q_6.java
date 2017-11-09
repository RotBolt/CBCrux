package assignment_8a;

import java.util.ArrayList;

public class Q_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 3, 5, 7, 0 };
		System.out.println(get_group(arr, 0, 0, 0));
	}

	public static int count_group(int[] arr, int sg1, int sg2, int si) {
		if (si == arr.length) {
			if (sg1 == sg2) {
				return 1;
			}
			return 0;
		}
		int count = 0;
		count += count_group(arr, sg1 + arr[si], sg2, si + 1);
		if (si != 0) {
			count += count_group(arr, sg1, sg2 + arr[si], si + 1);
		}
		return count;
	}

	public static void prin_group(int[] arr, int sg1, int sg2, int si, String val1, String val2) {
		if (si == arr.length) {
			if (sg1 == sg2) {
				System.out.print(val1 + " and ");
				System.out.println(val2);
			}
			return;
		}
		prin_group(arr, sg1 + arr[si], sg2, si + 1, val1 + arr[si], val2);
		if (si != 0) {
			prin_group(arr, sg1, sg2 + arr[si], si + 1, val1, val2 + arr[si]);
		}

	}

	static public ArrayList<String> get_group(int[] arr, int sg1, int sg2, int si) {
		if (si == arr.length) {
			ArrayList<String> base = new ArrayList<>();
			if (sg1 == sg2) {
				base.add(" ");
			}
			return base;
		}
		ArrayList<String> f_res = new ArrayList<>();
		ArrayList<String> res1 = new ArrayList<>();
		ArrayList<String> res2 = new ArrayList<>();
		res1 = get_group(arr, sg1 + arr[si], sg2, si + 1);
		res2 = get_group(arr, sg1, sg2 + arr[si], si + 1);
		if (res1.size() != 0) {
			for (int i = 0; i < res1.size(); i++) {
				f_res.add(arr[si] + res1.get(i));
			}
			f_res.add(" and ");
			
		}
	
		if(res2.size()!=0) {
			for (int i = 0; i < res2.size(); i++) {
				f_res.add(arr[si] + res2.get(i));
			}
		}

		return f_res;
	}

}
