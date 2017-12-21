package leetCode351_400;

import java.util.Arrays;
import java.util.Comparator;

public class LC_354_RussianDollEnvelopes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] envelopes = {{10,8},{1,12},{6,15},{2,18}};
		maxEnvelopes( envelopes);
		
	}

    public static int maxEnvelopes(int[][] envelopes) {
    	int len = envelopes.length;
    	if(len==0)
    		return 0;
    	int[] dp = new int[len];
    	dp[0] = 1;
        Comparator<int[]> com = new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]!=o2[0])
					return o1[0]-o2[0];
				else {
					return o1[1]-o2[1];
				}
			}	
        };
        Arrays.sort(envelopes, com);
        for(int i=1;i<len;i++) {
        	dp[i]=1;
        	for(int j=0;j<i;j++) {
        		if(envelopes[i][0]>envelopes[j][0] &&envelopes[i][1]>envelopes[j][1] ) {
        			if(dp[i]<dp[j]+1)
        				dp[i] = dp[j]+1;
        		}
        	}
        }
        return dp[len-1];
    }
}
