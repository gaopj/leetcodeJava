package leetCode251_300;

import java.util.HashMap;
import java.util.Map;

public class LC_299_BullsAndCows {

    public String getHint(String secret, String guess) {
        int Acount = 0;
        int Bcount = 0;
        Map<Character,Integer> mapse = new HashMap<>();
        Map<Character,Integer> mapgu = new HashMap<>();
        for(int i=0 ;i<secret.length();i++) {
        	char sec = secret.charAt(i);
        	char gu = guess.charAt(i);
        	if(sec==gu)
        		Acount++;
        	else {
        		if(mapse.containsKey(sec)) {
        			mapse.put(sec, mapse.get(sec)+1);
        		}else {
        			mapse.put(sec, 1);
        		}
        		if(mapgu.containsKey(gu)) {
        			mapgu.put(gu, mapgu.get(gu)+1);
        		}else {
        			mapgu.put(gu, 1);
        		}
        	}
        }
        for(Map.Entry<Character,Integer> e:mapgu.entrySet()) {
        	if(mapse.containsKey(e.getKey()))
        		Bcount+=Math.min(mapse.get(e.getKey()),e.getValue());
        }
        return Acount+"A"+Bcount+"B";
    }
}
