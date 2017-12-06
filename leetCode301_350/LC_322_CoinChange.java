package leetCode301_350;

import java.util.Arrays;

public class LC_322_CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int coinChange(int[] coins, int amount) {
       int[] amounts = new int[amount+1];
       Arrays.sort(coins);
       amounts[0] = 0;
       for(int i=1;i<amount+1;i++) {
    	   amounts[i] = Integer.MAX_VALUE;
    	   for(int j=0;j<coins.length;j++) {
    		   if(i-coins[j]<0) {
    			   break;
    		   }
    		   if(amounts[i-coins[j]]!=Integer.MAX_VALUE)
    		   amounts[i] = (amounts[i]<amounts[i-coins[j]]+1)?amounts[i]:amounts[i-coins[j]]+1;
    	   }
       }
       return amounts[amount]==Integer.MAX_VALUE?-1:amounts[amount];
    }
}
