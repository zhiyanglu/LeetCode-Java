/**
 * Implement a trie with insert, search, and startsWith methods.
 * You may assume that all inputs are consist of lowercase letters a-z.
 * @author Lu
 */
class TrieNode {
	// Initialize your data structure here.
	public String word = "";
	public TrieNode[] children = new TrieNode[26];
}

public class Trie {

	public static void main(String[] args) {
		Trie root = new Trie();
		root.insert("app");
		// root.insert("apple");
		root.insert("beer");
		// root.insert("add");
		root.insert("jam");
		root.insert("rental");
		System.out.println(root.search("apps"));
		System.out.println(root.search("app"));
	}

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
    	TrieNode cur = root;
    	for(char c: word.toCharArray()){
    		if(cur.children[c - 'a'] == null){
    			cur.children[c - 'a'] = new TrieNode();
    		}
			cur = cur.children[c - 'a'];
    	}
    	cur.word = word;
    }

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode cur = root;
		for (char c : word.toCharArray()) {
			if (cur.children[c - 'a'] == null)
				return false;
			cur = cur.children[c - 'a'];
		}
		return cur.word.equals(word);
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode cur = root;
		for (char c : prefix.toCharArray()) {
			if (cur.children[c - 'a'] == null)
				return false;
			cur = cur.children[c - 'a'];
		}
		return true;
	}
}
