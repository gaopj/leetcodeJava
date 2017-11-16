package leetCode251_300;

import java.util.HashMap;
import java.util.Map;

public class LC_290_WordPattern {

    public boolean wordPattern(String pattern, String str) {
        if(pattern == null||str==null)
        	return false;
        String[] words = str.split(" ");
        if(words.length!=pattern.length())
        	return false;
        
        Map<Character,String> map = new HashMap<>();
        
        for(int i=0;i<words.length;i++) {
        	char c = pattern.charAt(i);
        	if(map.containsKey(c)) {
        		if(!map.get(c).equals(words[i]))
        			return false;
        	}else {
        		if(map.containsValue(words[i])) {
        			return false;
        		}
        		map.put(c, words[i]);
        	}
        }
        return true;
    }
}
