package leetCode201_250;

import java.util.HashMap;
import java.util.Map;

public class LC_208_ImplementTrie {

	class TrieNode{
		char c;
		boolean leaf;
		HashMap<Character,TrieNode> children = new HashMap<Character,TrieNode>();
		
		public TrieNode(char c) {
			this.c = c;
		}
		
		public TrieNode() {
		}
	}
	
	
	class Trie {

		private TrieNode root;
		
	    /** Initialize your data structure here. */
	    public Trie() {
	    	root = new TrieNode();
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
	    public boolean search(String word) {
	    	TrieNode t = searchNode(word);
	    	return t!=null && t.leaf;
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	        return searchNode(prefix)!=null;
	    }
	    
	    private TrieNode searchNode(String word) {
	    	 Map<Character,TrieNode>  children= root.children;
	    	 TrieNode t=null;
	    	 for(int i=0 ;i<word.length();i++) {
	    		 char c = word.charAt(i);
	    		 if(!children.containsKey(c)) return null;
	    		 t = children.get(c);
	    		 children = t.children;
	    	 }
	    	 return t;
	    }
	}

	/**
	 * Your Trie object will be instantiated and called as such:
	 * Trie obj = new Trie();
	 * obj.insert(word);
	 * boolean param_2 = obj.search(word);
	 * boolean param_3 = obj.startsWith(prefix);
	 */
}
