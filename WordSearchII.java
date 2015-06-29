import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, 
 * find all words in the board.
 * Each word must be constructed from letters of sequentially
 * adjacent cell, where "adjacent" cells are those horizontally
 * or vertically neighboring. 
 * The same letter cell may not be used more than once in a word.
 * For example,
 * Given words = ["oath","pea","eat","rain"] and board =
 * [['o','a','a','n'],
 * 	['e','t','a','e'],
 * 	['i','h','k','r'],
 * 	['i','f','l','v']]
 * Return ["eat","oath"].
 * @author Lu
 *
 */
public class WordSearchII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {
				  {'o','a','a','n','a','n'},
				  {'e','t','a','e','a','n'},
				  {'i','h','k','r','a','n'},
				  {'i','f','l','v','a','n'},
				  {'i','f','l','v','a','n'},
		};
		String[] words = {"athfiieo"};
		System.out.println(new WordSearchII().findWords(board, words));
	}

	
	
	
	
	
	
	
	/**
	 * Use backtracking and Trie Tree --- Slow soution
	 */
	private TrieNode root = new TrieNode();
	class TrieNode {
		public TrieNode[] children = new TrieNode[26];
		public String item = "";
	}
	public void addWord(String word) {
		TrieNode cur = root;
		for (char c : word.toCharArray()) {
			if (cur.children[c - 'a'] == null) {
				cur.children[c - 'a'] = new TrieNode();
			}
			cur = cur.children[c - 'a'];
		}
		cur.item = word;
	}
	public boolean searchWord(String word) {
		TrieNode cur = root;
		for (char c : word.toCharArray()) {
			if (cur.children[c - 'a'] == null)
				return false;
			cur = cur.children[c - 'a'];
		}
		return !cur.item.equals("");
	}
	public List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<String>();
		if (board.length == 0)
			return result;
		boolean[][] used = new boolean[board.length][board[0].length];

		StringBuilder sb = new StringBuilder();
		// add all possible words to the TrieTree
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.println(i + " " + j);

				build(board, used, i, j, sb);
				
			}
		}
		for (int i = 0; i < words.length; i++) {
			if (searchWord(words[i])) {
				result.add(words[i]);
			}
		}
		return result;
	}
	private void build(char[][] board, boolean[][] used, int x, int y,
			StringBuilder sb) {
		addWord(sb.toString());
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
			return;
		if (used[x][y])
			return;

		used[x][y] = true;
		sb.append(board[x][y]);
		build(board, used, x + 1, y, sb);
		build(board, used, x - 1, y, sb);
		build(board, used, x, y + 1, sb);
		build(board, used, x, y - 1, sb);
		used[x][y] = false;
		sb.deleteCharAt(sb.length() - 1);
		return;

	}

}
