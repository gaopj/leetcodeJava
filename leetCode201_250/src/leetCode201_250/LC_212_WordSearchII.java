package leetCode201_250;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import leetCode201_250.LC_208_ImplementTrie.TrieNode;

public class LC_212_WordSearchII {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] board = {{'a','a'}};
		String[] words = {"a"};
		findWords(board,words);
	}
	
    public static List<String> findWords(char[][] board, String[] words) {
    	
    	Trie t = new Trie(board.length,board[0].length);
    	for(String s:words) {
    		t.insert(s);
    	}
    	
    	for(int i=0;i<t.row;i++) {
    		for(int j=0;j<t.col;j++) {
    			if(t.root.children.containsKey(board[i][j]))
    			t.search(board,  t.root.children.get(board[i][j]), i, j, "");
    		}
    	}
    	
    	return t.res;
    }

	static class TrieNode{
		char c;
		boolean leaf;
		HashMap<Character,TrieNode> children = new HashMap<Character,TrieNode>();
		
		public TrieNode(char c) {
			this.c = c;
		}
		
		public TrieNode() {
		}
	}
	
	
	static class Trie {

		private TrieNode root;
		List<String> res =new LinkedList<String>();
    	int row ;
    	int col ;
	    /** Initialize your data structure here. */
	    public Trie(int r,int c) {
	    	root = new TrieNode();
	    	row=r;
	    	col =c;
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        Map<Character,TrieNode>  children= root.children;
	        for(int i=0;i<word.length();i++) {
	        	char c = word.charAt(i);
	        	TrieNode t;
	        	if(children.containsKey(c)) {
	        		t =children.get(c);
	        	}else {
	        		t = new TrieNode(c);
	        		children.put(c, t);
	        	}
	        	children = t.children;
	        	if(i==word.length()-1) t.leaf=true;
	        }
	        
	    }
	    
	    /** Returns if the word is in the trie. */
	    public void search(char[][] board, TrieNode root, int x, int y, String str) {
	    	if(root==null||board[x][y]=='#') {
	    		return;
	    	}
	    	
	    	str+=board[x][y];
	    	if(root.leaf) {
	    		res.add(str);
	    		root.leaf=false;
	    	}
	    	
	    	char ch = board[x][y];  
	        board[x][y] = '#';
	        
	        if(x+1 < row) 
	        	search(board, root.children.get(board[x+1][y]), x+1, y, str);  
	        if(x-1 >= 0) 
	        	search(board,root.children.get(board[x-1][y]), x-1, y, str);  
	        if(y+1 < col) 
	        	search(board, root.children.get(board[x][y+1]), x, y+1, str);  
	        if(y-1 >= 0) 
	        	search(board,root.children.get(board[x][y-1]), x, y-1, str); 
	        
	        board[x][y] = ch;
	    }
	    
	 
	}
}
