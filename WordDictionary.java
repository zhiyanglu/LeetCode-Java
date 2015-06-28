/**
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string
 * containing only letters a-z or .. A . means it can represent any one letter.
 * 
 * Example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 *  
 * @author Lu
 *
 */
public class WordDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDictionary dict = new WordDictionary();
		dict.addWord("ran");
		dict.addWord("rune");
		dict.addWord("runner");
		dict.addWord("runs");
		dict.addWord("add");
		dict.addWord("adds");
		dict.addWord("adder");
		dict.addWord("addee");
		

		System.out.println(dict.search("....e."));

	}

	private class TrieNode{
		public TrieNode[] children = new TrieNode[26];
		public String item = "";
	}
	
	private TrieNode root = new TrieNode();
	
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
        	if(cur.children[c - 'a'] == null){
        		cur.children[c - 'a'] = new TrieNode();
        	}
    		cur = cur.children[c - 'a'];
        }
        cur.item = word;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	return search(word.toCharArray(), 0, root);
    }
    private boolean search(char[] word, int index, TrieNode node){
    	if(node == null) return false;
    	if(index == word.length) return !node.item.equals("");
    	if(word[index] != '.'){
    		return search(word, index+1, node.children[word[index] - 'a']);
    	}else{
    		for(char c = 'a'; c <= 'z'; c++){
//    			word[index] = c;
    			if(search(word, index+1, node.children[c - 'a'])) return true;
    		}
    	}
		return false;
    }

	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");
}
