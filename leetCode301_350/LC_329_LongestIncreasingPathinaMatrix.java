package leetCode301_350;

public class LC_329_LongestIncreasingPathinaMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int[][] dp;
	int n;
	int m;

    public int longestIncreasingPath(int[][] matrix) {
    	int res=0;
        n = matrix.length;
        if(n==0)
        	return 0;
        m = matrix[0].length;
        dp = new int[n][m];
        for(int i=0;i<n;i++) {
        	for(int j=0;j<m;j++) {
        		res = Math.max(res, dfs( matrix,i,j,-1));
        	}
        }
        return res;
    }
    
    private int dfs(int[][] matrix,int x,int y,int last) {
    	if(x<0||x>=n||y<0||y>=m)
    		return 0;
    	if(matrix[x][y]>last) {
    		if(dp[x][y]!=0) return dp[x][y];
    		int up = dfs(matrix,x-1, y,matrix[x][y])+1;
    		int down = dfs(matrix,x+1, y,matrix[x][y])+1;
    		int left = dfs(matrix,x, y-1,matrix[x][y])+1;
    		int right = dfs(matrix,x, y+1,matrix[x][y])+1;
    		dp[x][y] = Math.max(Math.max( Math.max(up,down),left),right);
    		return dp[x][y];
    	}
    	return 0;
    }
}
