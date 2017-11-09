package lec_21_class;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Trie {
	private class Node {
		Character data;
		HashMap<Character, Node> children;
		boolean isTerminal;

		Node(Character data, boolean isTerminal) {
			this.data = data;
			this.isTerminal = isTerminal;
			children = new HashMap<>();
		}
	}

	private int numWords;
	private Node root;

	Trie() {
		this.root = new Node('\0', false);
		this.numWords = 0;
	}

	public int get_numWords() {
		return this.numWords;
	}

	public boolean isEmpty() {
		return this.numWords == 0;
	}

	public void addWord(String word) {
		this.addWord(this.root, word);
	}

	private void addWord(Node parent, String word) {
		if (word.length() == 0) {
			if (parent.isTerminal) {

			} else {
				parent.isTerminal = true;
				this.numWords++;
			}
			return;
		}
		Node child = parent.children.get(word.charAt(0));
		String ros = word.substring(1);
		if (child == null) {
			child = new Node(word.charAt(0), false);
			parent.children.put(word.charAt(0), child);
		}
		this.addWord(child, ros);
	}

	public void display_words() {
		display_words(this.root, "");
	}

	private void display_words(Node parent, String osf) {
		if (parent.isTerminal) {
			System.out.println(osf);
			// return;
		}
		Set<Map.Entry<Character, Node>> words = parent.children.entrySet();
		for (Map.Entry<Character, Node> charac : words) {
			String osf_beta = osf + charac.getKey();
			// doesn't add '\0' with charac.getkey();
			display_words(charac.getValue(), osf_beta);
		}
	}

	public boolean search(String word) {
		return this.search(this.root, word);
	}

	private boolean search(Node parent, String word) {
		if (word.length() == 0) {
			if (parent.isTerminal) {
				return true;
			} else {
				return false;
			}
		}
		char cc = word.charAt(0);
		String ros = word.substring(1);
		if (!parent.children.containsKey(cc)) {
			return false;
		}
		Node child = parent.children.get(cc);
		return this.search(child, ros);
	}

	public void remove(String word) {
		remove(this.root, word);
	}

	private void remove(Node node, String word) {
		if (word.length() == 0) {
			if (node.isTerminal) {
				node.isTerminal = false;
				this.numWords--;

			} else {

			}

			return;
		}
		Node child = node.children.get(word.charAt(0));
		if (child == null) {
			return;
		}
		this.remove(child, word.substring(1));
		if (!child.isTerminal && child.children.size() == 0) {
			child.children.remove(child);
		}
	}

	public void tree_type_display() {
		this.tree_type_display(this.root);
	}

	private void tree_type_display(Node parent) {
		   // make string for this problem
           System.out.print(parent.data+" => ");
           // null+ something = null thats why not working
           Set<Map.Entry<Character, Node>>words = parent.children.entrySet();
           for(Map.Entry<Character, Node>charac:words){
        	   System.out.print(charac.getKey()+", ");
           }
           System.out.println("END");
           for(Map.Entry<Character, Node>charac:words){
        	   this.tree_type_display(charac.getValue());
           }
		
	}
}
