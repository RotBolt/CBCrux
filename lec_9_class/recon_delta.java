package lec_9_class;

import java.util.ArrayList;

public class recon_delta {
	static boolean start = false;

	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer();
		// TODO Auto-generated method stub
		// System.out.println(maze_path_diag(2,2,0,0));
		// ArrayList<String> ans =getmazepath_diag(2,2,0,0);
		// System.out.println(ans + "\n" + ans.size());
		// printmazepath_diag(2, 2, 0, 0, "");
		// System.out.println(aaa_overlap("vcaaaaaa",0,0));
		// boolean[][] board = new boolean[4][4];
		// System.out.println(getNqueens(board, 0));
		// int [] one={1,2,5,7,8,10,90,100,766};
		// int [] two={3,4,5,9,11,50};
		// int [] merge=merge(one,two);
		// for(int i=0;i<merge.length;i++){
		// System.out.print(merge[i]+"\t");
		// }
		System.out.println(maze_path(3, 3, 0, 0));
	
	}

	public static int maze_path(int end_r, int end_c, int curr_c, int curr_r) {
		if (curr_r == end_r && curr_c == end_c) {
			return 1;
		}
		if (curr_r > end_r || curr_c > end_c) {
			return 0;
		}
		int count = 0;
		count = count + maze_path(end_r, end_c, curr_c, curr_r + 1);
		count = count + maze_path(end_r, end_c, curr_c + 1, curr_r);
		return count;
	}

	public static ArrayList<String> getmazepath(int end_r, int end_c, int curr_c, int curr_r) {
		if (curr_r == end_r && curr_c == end_c) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		if (curr_r > end_r || curr_c > end_c) {
			ArrayList<String> base = new ArrayList<>();
			return base;
		}

		ArrayList<String> total_path = new ArrayList<>();
		ArrayList<String> rem_path = null;
		rem_path = getmazepath(end_r, end_c, curr_c, curr_r + 1);
		for (int i = 0; i < rem_path.size(); i++) {
			total_path.add("H" + rem_path.get(i));
		}
		rem_path = getmazepath(end_r, end_c, curr_c + 1, curr_r);
		for (int i = 0; i < rem_path.size(); i++) {
			total_path.add("V" + rem_path.get(i));
		}
		return total_path;
	}

	public static void printmazepath(int end_r, int end_c, int curr_c, int curr_r, String path) {
		if (curr_r == end_r && curr_c == end_c) {
			System.out.println(path);
			return;
		}
		if (curr_r > end_r || curr_c > end_c) {
			return;
		}

		printmazepath(end_r, end_c, curr_c, curr_r + 1, 'H' + path);
		printmazepath(end_r, end_c, curr_c + 1, curr_r, 'V' + path);

	}

	public static int maze_path_diag(int end_r, int end_c, int curr_c, int curr_r) {
		if (curr_r == end_r && curr_c == end_c) {
			return 1;
		}
		if (curr_r > end_r || curr_c > end_c) {
			return 0;
		}
		int count = 0;
		count = count + maze_path_diag(end_r, end_c, curr_c, curr_r + 1);
		count = count + maze_path_diag(end_r, end_c, curr_c + 1, curr_r + 1);
		count = count + maze_path_diag(end_r, end_c, curr_c + 1, curr_r);
		return count;
	}

	public static ArrayList<String> getmazepath_diag(int end_r, int end_c, int curr_c, int curr_r) {
		if (curr_r == end_r && curr_c == end_c) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		if (curr_r > end_r || curr_c > end_c) {
			ArrayList<String> base = new ArrayList<>();
			return base;
		}

		ArrayList<String> total_path = new ArrayList<>();
		ArrayList<String> rem_path = null;
		rem_path = getmazepath_diag(end_r, end_c, curr_c, curr_r + 1);
		for (int i = 0; i < rem_path.size(); i++) {
			total_path.add("H" + rem_path.get(i));
		}
		rem_path = getmazepath_diag(end_r, end_c, curr_c + 1, curr_r);
		for (int i = 0; i < rem_path.size(); i++) {
			total_path.add("V" + rem_path.get(i));
		}
		rem_path = getmazepath_diag(end_r, end_c, curr_c + 1, curr_r + 1);
		for (int i = 0; i < rem_path.size(); i++) {
			total_path.add("D" + rem_path.get(i));
		}
		return total_path;
	}

	public static void printmazepath_diag(int end_r, int end_c, int curr_c, int curr_r, String path) {
		if (curr_r == end_r && curr_c == end_c) {
			System.out.println(path);
			return;
		}
		if (curr_r > end_r || curr_c > end_c) {
			return;
		}

		printmazepath_diag(end_r, end_c, curr_c, curr_r + 1, 'H' + path);
		printmazepath_diag(end_r, end_c, curr_c + 1, curr_r + 1, 'D' + path);
		printmazepath_diag(end_r, end_c, curr_c + 1, curr_r, 'V' + path);

	}

	public static int aaa_overlap(String str, int count, int fcount) {
		if (str.length() == 0) {
			return fcount;
		}
		if (count == 3) {
			return 1;// return final count of aaa
		}
		if (str.charAt(0) != 'a') {
			start = false;
			fcount += aaa_overlap(str.substring(1), count, fcount);
		}
		if (start == true) {
			fcount += aaa_overlap(str.substring(1), count + 1, fcount);
			fcount += aaa_overlap(str.substring(2), count - 1, fcount);
		} else if (str.charAt(0) == 'a') {
			start = true;
			fcount += aaa_overlap(str.substring(1), count + 1, fcount);
		}
		return fcount;
	}

	public static int countNqueens(boolean[][] board, int row) {
		if (row == board.length) {
			return 1;
		}
		int count = 0;
		for (int col = 0; col < board[row].length; col++) {
			if (isitsafe(board, row, col)) {
				board[row][col] = true;
				count += countNqueens(board, row + 1);
				board[row][col] = false;// back tracking
			}
		}
		return count;
	}

	public static boolean isitsafe(boolean[][] board, int row, int col) {
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == true) {
				return false;
			}
		}
		for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
			if (board[i][j] == true) {
				return false;
			}
		}
		for (int i = row; i >= 0; i--) {
			if (board[i][col] == true) {
				return false;
			}
		}
		return true;

	}

	public static ArrayList<String> getNqueens(boolean[][] board, int row) {
		if (row == board.length) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		ArrayList<String> total_path = new ArrayList<>();
		ArrayList<String> rem_path = null;

		for (int col = 0; col < board[row].length; col++) {
			if (isitsafe(board, row, col)) {
				board[row][col] = true;
				rem_path = getNqueens(board, row + 1);
				for (int i = 0; i < rem_path.size(); i++) {
					total_path.add((row + 1) + "-" + (col + 1) + "," + rem_path.get(i));
				}

				board[row][col] = false;// back tracking
			}
		}
		return total_path;
	}

	public static void printNqueens(boolean[][] board, int row, String path) {
		if (row == board.length) {
			System.out.println(path);
			return;
		}

		for (int col = 0; col < board[row].length; col++) {
			if (isitsafe(board, row, col)) {
				board[row][col] = true;
				printNqueens(board, row + 1, (path + row + "-" + col + ","));
				board[row][col] = false;// back tracking
			}
		}
	}

	// no recon
	public static int[] merge(int[] one, int[] two) {
		int[] merge = new int[one.length + two.length];
		int i, j, k, small, count = 0;
		if (one.length > two.length) {
			small = two.length;
		} else
			small = one.length;
		for (i = 0, j = 0, k = 0; i < one.length && j < two.length;) {
			if (one[i] > two[j]) {
				merge[k++] = two[j++];
			} else {
				merge[k++] = one[i++];
			}
			count++;
		}
		if (i >= 0) {
			while (i < one.length) {
				merge[k++] = one[i++];
			}
		}
		if (j >= 0) {
			while (j < two.length) {
				merge[k++] = two[j++];
			}
		}
		return merge;
	}

}
