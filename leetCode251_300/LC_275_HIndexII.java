package leetcode;

public class LC_275_HIndexII {
    public int hIndex(int[] citations) {
        if(citations.length==0)
        	return 0;
        int s=0,end=citations.length-1;
        int res=0,mid=0;
        int length = citations.length;
        while(s<=end){
        	mid = s+(end-s)/2;
        	if(citations[mid]>=length-mid){
        		end=mid-1;
        		res = length-mid;
        	}else
        	{
        		s=mid+1;
        	}
        	
        }
        return res;
    }
}
