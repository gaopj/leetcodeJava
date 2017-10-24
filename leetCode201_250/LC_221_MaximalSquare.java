package leetCode201_250;

public class LC_221_MaximalSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int maximalSquare(char[][] matrix) {
    	if(matrix.length<1) return 0;
    	int res =0;
        int h = matrix.length;
        int w = matrix[0].length;
        int[][] vec = new int[2][w];
        for(int j = 0;j<w;j++) {
        	vec[1][j]=0;
            vec[0][j]=0;
        }
        
        for (int i=0;i<h;i++) {
        	for(int j=0;j<w;j++) {
        		vec[i%2][j] = 0;
        		if(matrix[i][j]=='1') {
        			vec[i%2][j]=1;
        			if(i>0&&j>0)
        				vec[i%2][j] +=Math.min(Math.min(vec[(i-1)%2][j], vec[i%2][j-1]), vec[(i-1)%2][j-1]);
        		}
        		res = Math.max(vec[i%2][j], res);
        	}
        }
        return res*res;
    }
}
