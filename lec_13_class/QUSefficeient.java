package lec_13_class;

import lec_11_class.Dynamic_stack_inherit;
import lec_11_class.Stack_Arrays;

public class QUSefficeient {
	Dynamic_stack_inherit sprime;
	Dynamic_stack_inherit ssec;

	public QUSefficeient() {
		this.sprime = new Dynamic_stack_inherit();
		this.ssec = new Dynamic_stack_inherit();
	}

	public int size() {
		return this.sprime.size();
	}

	public boolean isempty() {
		return this.sprime.isEmpty();
	}

	public void enque(int item) throws Exception {
		this.sprime.push(item);
	}

	public int deque() throws Exception {
		while (sprime.size() != 1) {
			int item = this.sprime.pop();
			this.ssec.push(item);
		}
		int val1 = sprime.pop();
		while (ssec.isEmpty()) {
			int val = this.ssec.pop();
			this.sprime.push(val);
		}
		return val1;
	}

	public void display() throws Exception {
		boolean sfill = true;
		rev_stack(sprime, ssec, sprime.size(), sfill);
		this.sprime.display();
		sfill = true;
		rev_stack(sprime, ssec, sprime.size(), sfill);
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
