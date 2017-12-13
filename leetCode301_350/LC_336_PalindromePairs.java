package leetCode301_350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC_336_PalindromePairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String,Integer> m = new HashMap<>();
        Set<List<Integer>> s = new HashSet<>();
        int len = words.length;
        for(int i=0;i<len;i++) {
        	m.put(words[i], i);
        }
        
        for(int i=0;i<len;i++) {
        	int wordsLen = words[i].length();
        	for(int j=0;j<=wordsLen;j++) {
        		String left = words[i].substring(0, j);
        		String right = words[i].substring(j);
        		if(isPalindrome(left)) {
        			Integer temp = m.get(new StringBuilder(right).reverse().toString());
        			if(temp!=null&&temp!=i) {
        				List<Integer> list = new LinkedList<>();
        				list.add(temp);
        				list.add(i);
        				s.add(list);
        			}
        		}
        		if(isPalindrome(right)) {
        			Integer temp = m.get(new StringBuilder(left).reverse().toString());
        			if(temp!=null&&temp!=i) {
        				List<Integer> list = new LinkedList<>();
        				list.add(i);
        				list.add(temp);
        				s.add(list);
        			}
        		}
        	}
        }
        
        return new ArrayList<List<Integer>>(s);
    }
    
    private boolean isPalindrome(String s) {
    	int left = 0;
    	int right = s.length()-1;
    	while(left<right) {
    		if(s.charAt(left)!=s.charAt(right))
    			return false;
    		left++;
    		right--;
    	}
    	return true;
    }
}
