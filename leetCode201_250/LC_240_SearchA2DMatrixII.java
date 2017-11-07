package leetCode201_250;

public class LC_240_SearchA2DMatrixII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row==0)
            return false;
        int col = matrix[0].length;
        if(col==0)
        	return false;
        int i =0;
        int j = col-1;
        while(i<row&&j>=0) {
        	if(matrix[i][j]==target)
        		return true;
        	else if(matrix[i][j]<target)
        	{
        		i++;
        	}else {
        		j--;
        	}
        }
        return false;
    }
}
