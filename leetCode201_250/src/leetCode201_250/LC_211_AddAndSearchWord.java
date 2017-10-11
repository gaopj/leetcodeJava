package leetCode201_250;

import java.util.HashMap;
import java.util.Map;

import leetCode201_250.LC_208_ImplementTrie.TrieNode;

public class LC_211_AddAndSearchWord {

	static class WordDictionary {

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
		private TrieNode root;
		
	    /** Initialize your data structure here. */
	    public WordDictionary() {
	    	root = new TrieNode();
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
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
	    
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	    	return searchNode(word,0,root);
	    }
	    
	    private boolean searchNode(String word,int pos,TrieNode node) {

	    	if(pos>=word.length()) {
	    		return node.leaf;
	    	}
	    	char c = word.charAt(pos);
	    	if(c=='.') {
	    		for(Character a:node.children.keySet()) {
	    			if( searchNode( word,pos+1,node.children.get(a))) {
	    				return true;
	    			}
	    		}
	    		return false;
	    	}else {
	    		if(node.children.containsKey(c)) {
	    			return searchNode( word,pos+1,node.children.get(c));
	    		}else
	    			return false;
	    	}
	    	
	    }
	}
	static WordDictionary w ;
	public static void main(String[] args) {
		w = new WordDictionary();
		w.addWord("bad");
		w.addWord("dad");
		w.addWord("mad");
		w.search("pad");
		w.search("bad");
		w.search(".ad");
		w.search("b..");
		
	}
}
