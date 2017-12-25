package leetCode351_400;

public class LC_357_CountNumberswithUniqueDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		countNumbersWithUniqueDigits(1);
	}

    public static int countNumbersWithUniqueDigits(int n) {
        int res =1,max = (int)(Math.pow(10, n)),used=0;
        for(int i=1;i<10; ++i) {
			used |= (1<<i);
			res+= dfs(i,max,used);
			used &= ~(1<<i);
        }
        return res;
    }
    
   static int  dfs(int pre,int max,int used) {
    	int res =0;
    	if(pre<max) ++res;
    	else return res;
    	for(int i=0;i<10;i++) {
    		if((used & (1<<i))==0) {
    			used |= (1<<i);
    			int cur = 10 *pre +i;
    			res+= dfs(cur,max,used);
    			used &= ~(1<<i);
    		}
    	}
    	
    	return res;
    }
}
