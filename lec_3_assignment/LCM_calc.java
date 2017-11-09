package lec_3_assignment;

import java.util.Scanner;

public class LCM_calc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n1, n2;
		System.out.print("Enter the No.1 and No.2\n");
		n1 = in.nextInt();
		n2 = in.nextInt();
		int LCM = compute_LCM(n1, n2);
		System.out.print("LCM is " + LCM);
	}

	public static int compute_LCM(int n1, int n2) {
		int LCM = 1;
		if (n1 == 1 || n2 == 1)
			return (n1 * n2);
		while (n1 != 1 && n2 != 1) {
			int flag1 = 0;
			int flag2 = 0;
			int divisor1 = 2;
			int divisor2 = 2;
			while (divisor1 <= n1 || divisor2 <= n2) {
				if (n1 % divisor1 == 0 && n2 % divisor2 == 0) {
					LCM *= divisor1;
					flag1 = 1;
					flag2 = 1;
					n1 /= divisor1;
					n2 /= divisor2;
				} else if (n1 % divisor1 == 0) {
					LCM *= divisor1;
					n1 = n1 / divisor1;
					flag1 = 1;
				} else if (n2 % divisor2 == 0) {
					LCM *= divisor2;
					n2 = n2 / divisor2;
					flag2 = 1;
				}
				if (flag1 == 1 && flag2 == 1)
					break;
				if (flag1 == 0)
					divisor1++;
				if (flag2 == 0)
					divisor2++;
			}
		}
		return (LCM);
	}

}
