package leetCode351_400;

import java.util.ArrayList;
import java.util.List;

public class LC_373_FindKPairswithSmallestSums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums1 = {1,1,2};
		int[] nums2 = {1,2,3};
		kSmallestPairs(nums1,nums2,10);
	}

    public  static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    	int len1=nums1.length;
    	int len2 = nums2.length;
        int size = Math.min(k, len1*len2);
        List<int[]> res = new ArrayList<>();
        int[] idex = new int[len1];
        for(int i=0;i<size;i++) {
        	int sum=Integer.MAX_VALUE;
        	int nowMinPos=0;
        	for(int j=0;j<len1;j++) {
        		if(idex[j]<len2&& sum>nums1[j]+nums2[idex[j]]) {
        			sum = nums1[j]+nums2[idex[j]];
        			nowMinPos = j;
        		}
        	}
        	res.add(new int[]{nums1[nowMinPos],nums2[idex[nowMinPos]]});
        	idex[nowMinPos]++;
        }
        
        return res;
    }
}
