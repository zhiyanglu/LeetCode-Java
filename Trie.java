class TrieNode {
    // Initialize your data structure here.
    private char c;
    private String word;
    private TrieNode[] children;
	public TrieNode(){
    	children = new TrieNode[26];
    	word = "";		
	}	
	
    public TrieNode(char c) {
    	this.c = c;
    	children = new TrieNode[26];
    	word = "";
    }
    
    public String getWord(){
    	return word;
    }
    
    public TrieNode getChildren(char c){
    	return children[c - 'a'];
    }
    
    public void addChildren(char c){
    	if(children[c - 'a'] == null){
    		children[c - 'a'] = new TrieNode(c);
    	}
    }
    
    public void setWord(String s){
    	this.word = s;
    }
    
}

public class Trie {
	
	public static void main(String[] args){
		Trie root = new Trie();
		root.insert("app");
//		root.insert("apple");
		root.insert("beer");
//		root.insert("add");
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
    		if(cur.getChildren(c) == null){
    			cur.addChildren(c);
    		}
			cur = cur.getChildren(c);
    	}
    	cur.setWord(word);
    }
    // Returns if the word is in the trie.
    public boolean search(String word) {
    	TrieNode cur = root;
    	for(char c: word.toCharArray()){
    		if(cur.getChildren(c) == null) return false;
    		cur = cur.getChildren(c);
    	}
		return cur.getWord().equals(word);        
    }
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode cur = root;
    	for(char c : prefix.toCharArray()){
    		if(cur.getChildren(c) == null) return false;
    		cur = cur.getChildren(c);
    	}
    	return true;        
    }
}
