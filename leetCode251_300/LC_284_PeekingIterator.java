package leetCode251_300;

import java.util.Iterator;

public class LC_284_PeekingIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class PeekingIterator implements Iterator<Integer> {

		Iterator<Integer> i;
		Integer next;
		boolean hasPeek;
		public PeekingIterator(Iterator<Integer> iterator) {
		    // initialize any member here.
		    i = iterator;
		    hasPeek = false;
		}

	    // Returns the next element in the iteration without advancing the iterator.
		public Integer peek() {
	        if(!hasPeek) {
	        	next = i.next();
	        	hasPeek = true;
	        }
	        return next;
		}

		// hasNext() and next() should behave the same as in the Iterator interface.
		// Override them if needed.
		@Override
		public Integer next() {
		    if(hasPeek)
		    {
		    	hasPeek = false;
		    	return next;
		    }
		    else {
		    	return i.next();
		    }
		}

		@Override
		public boolean hasNext() {
		    return hasPeek?next!=null : i.hasNext();
		}
	}
}
