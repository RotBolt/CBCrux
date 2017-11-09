package lec_16_class;

public class CLIENT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 80 3 40 2 110 0 120 0 60 0 70 1 140 0
		Generic_tree gt = new Generic_tree();
		gt.display();
		// System.out.println(gt.size2());
		// System.out.println(gt.max());
		// System.out.println(gt.height());
		// System.out.println(gt.find(120));
		// gt.mirror();
		// System.out.println("************************");
		// gt.display();
		// gt.print_at_level(2);
		// gt.pre_order_traversal();
		// gt.level_order_traversal();
		// gt.post_order_traversal();
		System.out.println(gt.height());
	}

}
