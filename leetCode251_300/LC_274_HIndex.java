package leetcode;

import java.util.Arrays;

public class LC_274_HIndex {
    public int hIndex(int[] citations) {
        if(citations.length==0)
        	return 0;
        Arrays.sort(citations);
        int res =0;
        for(int i=citations.length-1;i>=0;i++){
        	int h = citations.length-i;
        	if(citations[i]>=h)
        		res=h;
        	else{
        		break;
        	}
        }
        
        return res;
    }
}
