package leetCode201_250;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LC_207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	List<Set<Integer>> posts = new ArrayList<Set<Integer>>(); 	
    	for(int i=0;i<numCourses;i++) {
    		posts.add(new HashSet<Integer>());
    	}
    	
    	for(int i=0;i<prerequisites.length;i++) {
    		posts.get(prerequisites[i][1]).add(prerequisites[i][0]);
    	}
    	
    	int[] preNums = new int[numCourses];
    	for(int i=0;i<numCourses;i++) {
    		Set s = posts.get(i);
    		Iterator<Integer> iter = s.iterator();
    		while(iter.hasNext()) {
    			preNums[iter.next()]++;
    		}
    	}
    	
    	Queue<Integer> q = new LinkedList<Integer>();
    	for(int i=0;i<numCourses;i++) {
    		if(preNums[i]==0) {
    			q.offer(i);
    		}
    	}
    	
    	int	count = numCourses;
    	while(!q.isEmpty()) {
    		int now = q.poll();
    		count--;
    		for(int i:posts.get(now)) {
    			if(--preNums[i]==0) {
    				q.offer(i);
    			}
    		}
    	}
    	
    	
		return count==0;
        
    }
}
