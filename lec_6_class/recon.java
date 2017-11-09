package lec_6_class;

public class recon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr = { 1, 2, 2, 9, 2, 2 };
		//int[] indi = indices_array(arr, 0, 2, 0);
		//for (int i = 0; i < indi.length; i++) {
		//	System.out.println(indi[i]);
		//}
		pattern_pascal(0,0,5);

	}

	public static void prin_dec(int num) {
		if (num == 0)
			return;
		System.out.println(num);
		prin_dec(--num);
	}

	public static void prin_inc(int num) {
		if (num == 0)
			return;
		prin_inc(--num);
		System.out.println(num + 1);
	}

	public static void prin_dec_inc(int num) {
		if (num == 0)
			return;
		System.out.println(num);
		prin_dec_inc(--num);
		System.out.println(num + 1);
	}

	public static void prin_inc_dec_skip(int num) {
		if (num <= 0)
			return;
		// if(num%2!=0){
		System.out.println(num);
		// }
		prin_inc_dec_skip(num - 2);
		// if(num%2==0){
		if (num == 5)
			return;
		System.out.println(num + 1);
		// }
	}

	public static int factorial(int fact, int num) {
		if (num == 0)
			return fact;
		fact *= num;
		int f = factorial(fact, num - 1);
		return f;
	}

	public static int power(int f, int x, int n) {
		if (n == 0)
			return f;
		f *= x;
		int result = power(f, x, n - 1);
		return result;

	}

	public static boolean issorted(int[] arr, int first) {
		boolean check;
		if (arr[first] == arr[arr.length - 1])
			return true;

		if (arr[first] < arr[first + 1])
			check = issorted(arr, first + 1);
		else
			check = false;

		return check;
	}

	public static int iscontains(int[] arr, int first, int num) {
		int index;

		if (first == arr.length - 1) {
			if (arr[first] == num) {
				return first;
			} else {
				return -1;
			}
		}
		if (arr[first] == num) {
			return first;
		} else {
			index = iscontains(arr, first + 1, num);
		}
		return index;
	}

	public static int firstindex(int[] arr, int first, int num) {
		int index;

		if (first == arr.length - 1) {
			if (arr[first] == num) {
				return first;
			} else {
				return -1;
			}
		}
		if (arr[first] == num) {
			return first;
		} else {
			index = firstindex(arr, first + 1, num);
		}
		return index;
	}

	public static int lastindex(int[] arr, int last, int num) {
		int index;

		if (last == arr.length - 1) {
			if (arr[last] == num) {
				index = last;
			} else {
				return -1;
			}

		}
		index = lastindex(arr, last + 1, num);

		if (index == -1) {
			if (arr[last] == num) {
				index = last;
			} else
				return -1;
		}
		return index;
	}

	public static int[] indices_array(int[] arr, int si, int num, int count) {
		int index = 0;
		if (si == arr.length) {
			return new int[count];

		}
		int[] indi = null;

		if (arr[si] == num) {
			index = si;
			indi = indices_array(arr, si + 1, num, count+1);
			indi[count] = index;
		} else {
			indi = indices_array(arr, si + 1, num, count);
		}
		return indi;

	}
	public static void  pattern_1(int star, int t_ele,int rows){
		if(t_ele>rows)
			return;
		else if(star!=t_ele){
			System.out.print("* ");
			pattern_1(star+1,t_ele,rows);
		}
		else if(star==t_ele){
			System.out.println("*\n");
			star=1;
			pattern_1(star,t_ele+1,rows);
		}
	}
	public static void  pattern_pascal(int rows,int cols,int num){
		if(rows>num)// base case
			return;
		if(cols>rows){// for entering new line
			System.out.println();
			pattern_pascal(rows+1,0,num);
			return;
		}
		int r_fact=factorial(1,rows);
		int c_fact=factorial(1,cols);
		int r_c_fact=factorial(1,rows-cols);
		int value=r_fact/(c_fact*r_c_fact);
		System.out.print(value+"\t");
		pattern_pascal(rows,cols+1,num);
	}
	

}
