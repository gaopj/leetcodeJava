package leetCode301_350;

public class LC_304_RangeSumQuery2DImmutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class NumMatrix {

	private int[][] sum;
	
    public NumMatrix(int[][] matrix) {
    	int row=matrix.length;
    	if(row==0)
    		return;
    	int col = matrix[0].length;
    	sum = new int[row][col];
    	sum[0][0]=matrix[0][0];
    	for(int i=1;i<row;i++) {
    		sum[i][0] = sum[i-1][0]+matrix[i][0];
    	}
    	for(int i=1;i<col;i++) {
    		sum[0][i] = sum[0][i-1]+matrix[0][i];
    	}
        for(int i=1;i<row;i++) {
        	for(int j=1;j<col;j++) {
        		sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+matrix[i][j];
        	}
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
    	int lsum=0,tsum=0,ltsum=0;
    	
    	if(row1!=0)
    		lsum = sum[row1-1][col2];
    	if(col1!=0)
    		tsum = sum[row2][col1-1];
    	if(row1!=0&&col1!=0)
    		ltsum = sum[row1-1][col1-1];
    	
        return sum[row2][col2]-lsum-tsum+ltsum;
    }
}
