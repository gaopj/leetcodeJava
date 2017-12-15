package LC_301_350;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LC_347_TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Pair{
		int value;
		int count;
		public Pair(int v,int c){
			value =v;
			count = c;
		}
	}
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i :nums){
        	if(map.containsKey(i)){
        		map.put(i, map.get(i)+1);
        	}else{
        		map.put(i, 1);
        	}
        }
        
        PriorityQueue<Pair> q = new PriorityQueue<>(new Comparator<Pair>(){
        	public int compare(Pair a,Pair b){
        		return a.count-b.count;
        	}
        });
        
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
        	Pair p = new Pair(e.getKey(),e.getValue());
        	q.offer(p);
        	if(q.size()>k)
        		q.poll();
        }
        
        LinkedList<Integer> res = new LinkedList<>();
        while(!q.isEmpty()){
        	res.addFirst(q.poll().value);
        }
        return res;
        
    }
}
