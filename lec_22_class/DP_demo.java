package lec_22_class;

public class DP_demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int n = 4;
		int[] strg = new int[6];
		// int[][] board = new int[n + 1][n + 1];
		// System.out.println(maze_path_I(n));
		// System.out.println(maze_path_R(n, n, 0, 0, board));
		// String s1 = "abgb";
		// String s2 = "aggb";
		// System.out.println(LCS(s1, s2));
		System.out.println(cbpR_6(0, 0, 10, strg));

	}

	public static int cbpR(int curr, int end, int[] strg) {
		if (curr == end) {
			return 1;
		}
		if (strg[curr] != 0) {
			return strg[curr];
		}
		int count = 0;
		for (int i = 1; i <= 6; i++) {
			if (curr + i > end) {
				break;
			}
			count += cbpR(curr + i, end, strg);
		}
		strg[curr] = count;
		return count;
	}

	public static int cbpR_6(int curr, int step, int end, int[] strg) {
		if (curr == end) {
			return 1;
		}

		if (strg[strg.length - 1 - step] != 0) {
			return strg[strg.length - 1 - step];
		}
		int count = 0;
		for (int i = 1; i <= 6; i++) {
			if (curr + i > end) {
				break;
			}
			count += cbpR_6(curr + i, i - 1, end, strg);
		}
		for (int i = 0; i < 5; i++) {
			strg[i] = strg[i + 1];
		}
		strg[strg.length - 1] = count;
		return count;
	}

	public static int cbpI(int[] path) {
		path[path.length - 1] = 1;
		int end = path.length - 1;
		for (int i = path.length - 2; i >= 0; i--) {
			if (end - i < 6) {
				int j = i + 1;
				while (j <= end) {
					path[i] += path[j];
					j++;
				}
			} else {
				for (int j = i + 1; j <= i + 6; j++) {
					path[i] += path[j];
				}
			}
		}
		return path[0];
	}

	public static int maze_path_R(int end_r, int end_c, int curr_c, int curr_r, int[][] board) {
		if (curr_r == end_r && curr_c == end_c) {
			return 1;
		}
		if (curr_r > end_r || curr_c > end_c) {
			return 0;
		}
		if (board[curr_r][curr_c] != 0) {
			return board[curr_r][curr_c];
		}
		int count = 0;
		count = count + maze_path_R(end_r, end_c, curr_c, curr_r + 1, board);
		count = count + maze_path_R(end_r, end_c, curr_c + 1, curr_r, board);
		board[curr_r][curr_c] = count;
		return count;
	}

	public static int maze_path_I(int end) {
		int[][] board = new int[end + 1][end + 1];
		board[end][end] = 1;
		for (int i = end; i >= 0; i--) {
			for (int j = end; j >= 0; j--) {
				if (i == end || j == end) {
					board[i][j] = 1;
				} else {
					board[i][j] = board[i][j + 1] + board[i + 1][j];
				}

			}
		}
		return board[0][0];
	}

	public static int LCS(String str1, String str2) {
		if (str1.length() == 0 || str2.length() == 0) {
			return 0;
		}
		char c1 = str1.charAt(0);
		char c2 = str2.charAt(0);
		int rv = 0;
		if (c1 == c2) {
			String ros1 = str1.substring(1);
			String ros2 = str2.substring(1);
			rv = 1 + LCS(ros1, ros2);

		} else {

			int len1 = LCS(str1.substring(1), str2);
			int len2 = LCS(str1, str2.substring(1));
			rv = Math.max(len1, len2);
		}
		return rv;
	}

	public static int LCS_I(String s1, String s2) {
		int[][] strg = new int[s1.length() + 1][s2.length() + 1];
		strg[s1.length()][s2.length()] = 0;
		for (int i = s1.length(); i >= 0; i--) {
			for (int j = s2.length(); j >= 0; j--) {
				if (i == s1.length() || j == s2.length()) {
					strg[i][j] = 0;
					continue;
				}
				if (s1.charAt(i) == s2.charAt(j)) {
					strg[i][j] = strg[i + 1][j + 1] + 1;
				} else {
					strg[i][j] = Math.max(strg[i + 1][j], strg[i][j + 1]);
				}
			}
		}
		return strg[0][0];
	}

}
