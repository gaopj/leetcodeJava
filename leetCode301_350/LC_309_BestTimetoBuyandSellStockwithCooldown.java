package leetCode301_350;

public class LC_309_BestTimetoBuyandSellStockwithCooldown {

	private static final int BUY =0;
	private static final int SELL =1;
	private static final int COOLDOWN =2;
	static int max = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] price = {1,2,3,0,2};
		int m= maxProfit(price);
	}
    public static int maxProfit(int[] prices) {
    	//maxProfit(prices,0,BUY,-1,0);
    	//return max;
    	
    	return maxProfitDP( prices);
    }
    
    private static void maxProfit(int[] prices,int pos,int flag,int sellCount,int nowRes) {
    	
    	if(pos>=prices.length)
    	{
    		if(nowRes>max)
    			max=nowRes;
    		return;
    	}
    	if(flag==BUY) {
    		maxProfit(prices, pos+1,SELL,prices[pos],nowRes);
    		maxProfit(prices, pos+1,flag,sellCount,nowRes);
    	}else if(flag==SELL) {
    		if(prices[pos]-sellCount>0)
    			maxProfit(prices, pos+1,COOLDOWN,-1,nowRes+prices[pos]-sellCount);
    		maxProfit(prices, pos+1,flag,sellCount,nowRes);
    	}else {
    		maxProfit(prices, pos+1,BUY,-1,nowRes);
    	}
    	
    }
    
    public static int maxProfitDP(int[] prices) {
    	int buy = Integer.MIN_VALUE;
    	int prebuy = Integer.MIN_VALUE;
    	int sell =0;
    	int presell = 0;
    	for(int p:prices) {
    		prebuy = buy;
    		buy = Math.max(presell-p, prebuy);
    		presell = sell;
    		sell = Math.max(prebuy+p, presell);
    	}
    	
    	return sell;
    }
}
