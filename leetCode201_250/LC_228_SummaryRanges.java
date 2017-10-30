package leetCode201_250;

import java.util.LinkedList;
import java.util.List;

public class LC_228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
    	List<String> res = new LinkedList<String>();
    	if(nums==null||nums.length==0)
    		return res;
    	if(nums.length==1)
    	{
    		String  s = ""+nums[0];
    	}
    	
    	int star=nums[0],end=nums[0];
    	for(int i=1;i<nums.length;i++){
    		if(end+1 ==nums[i]){
                end++;
    			continue;
    		}else{
    			String  s;
    			if(star ==end){
    				  s = ""+star;
    			}else{
    				  s = ""+star+"->"+end;
    			}
    			res.add(s);
    			star =nums[i];
    			end = nums[i];
    		}
    	}
		String  s;
		if(star ==end){
			  s = ""+star;
		}else{
			  s = ""+star+"->"+end;
		}
		res.add(s);
    	return res;
    }
}
