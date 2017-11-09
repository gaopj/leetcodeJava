package leetCode251_300;

import java.util.LinkedList;
import java.util.List;

public class LC_264_UglyNumberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nthUglyNumber(7);
	}
    public static int nthUglyNumber(int n) {
        List<Integer> list = new LinkedList<>();
        int pos2=0,pos3=0,pos5=0;
        int val2=2,val3=3,val5=5;
        list.add(1);
        for(int i=1;i<n;i++) {
        	int temp = Math.min(val2, Math.min(val3, val5));
        	list.add(temp);
        	if(temp==val2) {
        		pos2++;
        		val2 = list.get(pos2)*2;
        	}
        	if(temp==val5) {
        		pos5++;
        		val5 = list.get(pos5)*5;
        	}
        	if(temp==val3){
        		pos3++;
        		val3= list.get(pos3)*3;
        	}
        }
        return list.get(n-1);
    }
}
