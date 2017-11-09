package assignment_8a;

public class Q_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Tower_of_hanoi(3,"Start","dest","helper"));
		prin_Tower_of_hanoi(3,"Source","Target","Spare");

	}

	public static int Tower_of_hanoi(int N, String Start, String dest, String helper) {
		if (N == 0) {
			return 0;
		}
		int count = 0;
		count += Tower_of_hanoi(N - 1, Start, helper, dest);
		count++;
		count += Tower_of_hanoi(N - 1,helper,dest,Start);
		return count;
	}
	public static void prin_Tower_of_hanoi(int N, String Start, String dest, String helper) {
		if (N == 0) {
			return;
		}
		
		prin_Tower_of_hanoi(N - 1, Start, helper, dest);
		System.out.println("Moving " + N + " disc from " + Start + " to " + dest);
		prin_Tower_of_hanoi(N - 1, helper,dest,Start);
		return;
	}
	

}
