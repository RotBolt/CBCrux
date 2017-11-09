package lec_19_class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import lec_14_and_15_class.linked_list_client;

public class Hash_map_demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] set1 = { 3,2,1};
		int[] set2 = { 3,2,1 };
		Arrays.sort(set1);
		System.out.println(min_swaps(set2, set1));

	}

	public static char max_F(String str) {
		HashMap<Character, Integer> yo = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (!yo.containsKey(str.charAt(i))) {
				yo.put(str.charAt(i), 1);
			} else {
				int update = yo.get(str.charAt(i));
				update++;
				yo.put(str.charAt(i), update);
			}
		}
		int max = yo.get(str.charAt(0));
		for (int i = 1; i < str.length() - 1; i++) {
			if (yo.get(str.charAt(i)) > max) {
				max = yo.get(str.charAt(i));
			}
		}
		char rv = '\0';
		Set<Map.Entry<Character, Integer>> entry = yo.entrySet();
		for (Map.Entry<Character, Integer> yep : entry) {
			if (yep.getValue() == max) {
				rv = yep.getKey();
			}
		}
		return rv;
	}

	public static ArrayList<Integer> intersection(int[] set1, int[] set2) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i < set1.length; i++) {
			if (!map.containsKey(set1[i])) {
				map.put(set1[i], false);
			}
		}
		for (int i = 0; i < set2.length; i++) {
			if (map.containsKey(set2[i])) {
				map.put(set2[i], true);
			}
		}
		StringBuilder str = new StringBuilder();
		ArrayList<Integer> intersect = new ArrayList<>();
		Set<Map.Entry<Integer, Boolean>> yo = map.entrySet();
		for (Map.Entry<Integer, Boolean> temp : yo) {
			if (temp.getValue()) {
				intersect.add(temp.getKey());
			}
		}
		return intersect;
	}

	public static boolean check_dupli(int[] arr) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		boolean res = true;
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				res = false;
				break;
			} else {
				map.put(arr[i], true);
			}
		}
		return res;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int min_swaps(int[] arr, int[] sorted) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < sorted.length; i++) {
			map.put(sorted[i], i);
		}
		int swaps = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != sorted[i]) {
				int pos = map.get(arr[i]);
				swap(arr, i, pos);
				swaps++;
			}
		}
		return swaps;
	}

}
