package leetCode201_250;

import java.util.LinkedList;
import java.util.Stack;

public class LC_232_ImplementQueueUsingStacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class MyQueue {

		Stack<Integer> s1= new Stack<>();
		Stack<Integer> s2= new Stack<>();
	    /** Initialize your data structure here. */
	    public MyQueue() {
	        
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        while(!s2.isEmpty()) {
	        	s1.push(s2.pop());
	        }
	        s1.push(x);
	        while(!s1.isEmpty()) {
	        	s2.push(s1.pop());
	        }
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	        return s2.pop();
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	    	return s2.peek();
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return s2.isEmpty();
	    }
	}
}
