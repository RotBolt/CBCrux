package lec_21_class;

public class CLIENT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie obj = new Trie();
		obj.addWord("art");
		obj.addWord("arts");
		obj.addWord("see");
		obj.addWord("seen");
		
		obj.display_words();
		obj.remove("seen");
		System.out.println("*****************************");
		obj.display_words();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`");
		obj.tree_type_display();

	}

}
