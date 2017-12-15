package LC_301_350;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LC_349_IntersectionofTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2= new HashSet<>();
        for(int i :nums1){
            s1.add(i);
        }
        for(int i :nums2){
            s2.add(i);
        }
        ArrayList<Integer> res= new ArrayList<>();
        
        for(int i:s2){
        	if(s1.contains(i))
        		res.add(i);
        }
        int size = res.size();
        int[] res0  = new int[size];
        for(int i=0;i<size;i++){
        	res0[i]  = res.get(i);
        }
        return res0;
    }
}
