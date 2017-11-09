package lec_11_class;

public class Stack_arr_rev {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Stack_Arrays s = new Stack_Arrays(5);
		for (int i = 1; i <= 5; i++) {
			s.push(i);
		}
		s.display();
		Stack_Arrays Helper = new Stack_Arrays(5);
		boolean sfill = true;
		rev_stack(s, Helper, s.size(), sfill);
		System.out.println("**************");
		s.display();
	}

	public static void rev_stack(Stack_Arrays s, Stack_Arrays Helper, int size, boolean sfill) throws Exception {
		if (sfill == true) {
			if (s.size() == 0) {
				return;
			}
		} else {
			if (Helper.size() == 0) {
				return;
			}

		}
		if (sfill == true) {
			int item = s.pop();
			rev_stack(s, Helper, size, sfill);
			Helper.push(item);
			if (Helper.size() != size) {
				return;
			}
			sfill = false;
		}
		if (sfill == false) {
			int val = Helper.pop();
			s.push(val);
			rev_stack(s, Helper, size, sfill);

		}
	}

}
