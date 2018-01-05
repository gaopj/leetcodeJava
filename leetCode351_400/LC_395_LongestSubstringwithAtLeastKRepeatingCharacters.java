package leetCode351_400;

import java.util.HashMap;
import java.util.Map;

public class LC_395_LongestSubstringwithAtLeastKRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		longestSubstring("aaabb",3);
	}

    public static int longestSubstring(String s, int k) {
        Map<Character,Integer> cMap = new HashMap<>();
        int lens = s.length();
        for(int i=0;i<lens;i++)
        {
        	char ch= s.charAt(i);
        	if(cMap.containsKey(ch)) {
        		cMap.put(ch, cMap.get(ch)+1);
        	}else {
        		cMap.put(ch, 1);
        	}
        }
        
        Character filter=null;
        
        for(Map.Entry<Character, Integer>e :cMap.entrySet()) {
        	if(e.getValue()<k) {
        		filter = e.getKey();
        		break;
        	}
        }
        
        if(filter==null)
        	return s.length();
        else {
        	String[] ss = s.split(filter+"");
        	int res =0;
        	for(String sub:ss) {
        		res = Math.max(res, longestSubstring(sub, k));
        	}
        	return res;
        }
    }
}
