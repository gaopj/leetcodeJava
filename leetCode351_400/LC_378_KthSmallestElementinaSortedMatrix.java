package LC_351_400;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_378_KthSmallestElementinaSortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>(){
        	@Override
        	public int compare(Integer o1,Integer o2){
        		return o2-o1;
        	}
        });
        
        int m = matrix.length;
        if(m==0)
        	return 0;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(heap.size()<k)
        			heap.offer(matrix[i][j]);
        		else{
        			if(heap.peek()>matrix[i][j]){
        				heap.poll();
        				heap.offer(matrix[i][j]);
        			}	
        		}
        	}
        }
        return heap.peek();
    }
}
