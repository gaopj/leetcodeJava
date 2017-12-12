package leetCode301_350;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LC_332_ReconstructItinerary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private LinkedList<String> res = new LinkedList<>();
	private Map<String,PriorityQueue<String>> g = new HashMap<>();
    public List<String> findItinerary(String[][] tickets) {
     
    	int bian = tickets.length;
    	for(int i=0;i<bian;i++) {
    		if(g.containsKey(tickets[i][0])) {
    			g.get(tickets[i][0]).offer(tickets[i][1]);
    		}else {
    			PriorityQueue<String> q = new PriorityQueue<>();
    			q.offer(tickets[i][1]);
    			g.put(tickets[i][0], q);
    		}
    	}
    	dfs("DFS");
    	return res;
    }
    
    void dfs(String s) {
    	PriorityQueue<String> q = g.get(s);
    	while(	q!=null&&!q.isEmpty()) {
    		dfs(q.peek());
    	}
    	res.addFirst(s);
    }
}
