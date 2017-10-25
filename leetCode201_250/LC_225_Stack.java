package leetCode201_250;

import java.util.LinkedList;
import java.util.Queue;

public class Stack {

	Queue<Integer> q = new LinkedList<>();
	void push(int x) {
		q.offer(x);
		for(int i=0;i<q.size()-1;i++) {
			q.offer(q.poll());
		}
	}
	
	void pop() {
		q.poll();
	}
	
	void top() {
		q.peek();
	}
	
	boolean empty() {
		 return q.isEmpty();
	}
}
	
