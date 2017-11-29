package leetCode301_350;

public class LC_312_BurstBalloons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int maxCoins(int[] nums) {
        int[] ns = new int[nums.length+2];
        ns[0]=ns[ns.length-1]=1;
        for(int i=1;i<ns.length-1;i++) {
        	ns[i] = nums[i-1];
        }
        int len =ns.length;
        int[][] coins = new int[len][len];
        for(int i=2;i<len;i++) {
        	for(int j=0;j+i<len;j++) {
        		for(int k=j+1;k<j+i;k++)
        			coins[j][i+j] = Math.max(coins[j][i+j], coins[j][k]+coins[k][i+j]+ns[j]*ns[k]*ns[j+i]);
        	}
        }
        
        return coins[0][len-1];
    }
}
