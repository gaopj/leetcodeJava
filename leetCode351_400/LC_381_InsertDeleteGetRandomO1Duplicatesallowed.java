package LC_351_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

public class LC_381_InsertDeleteGetRandomO1Duplicatesallowed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RandomizedCollection c= new RandomizedCollection();
		c.insert(1);
		c.remove(1);
		c.insert(1);
	}
}
class RandomizedCollection {

	Map<Integer,List<Integer>> map;
	List<Integer> list;
	int size;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        this.size = 0;
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
    	list.add(size,val);
    	List<Integer> mlist;
        if(map.containsKey(val)) {
        	mlist = map.get(val);
        }
        else{
        	mlist = new LinkedList<>();
        }
    	mlist.add(size++);
    	map.put(val, mlist);
    	return true;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            if (map.get(val).size() > 0) {
        		List<Integer> mlist =  map.get(val);
            	int tailKey = list.get(size-1);
            	List<Integer> tlist = map.get(tailKey);  	
            	tlist.remove(Integer.valueOf(size-1));
            	if(tailKey!=val){
                	int newPos = mlist.get(mlist.size()-1);
                	mlist.remove(mlist.size()-1);
                	tlist.add(newPos);
                	map.put(tailKey, tlist);
                	map.put(val, mlist);
                	list.set(newPos,tailKey);
            	}
            	size--;
            	return true;
            }
        }

        return false;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        Random rdm = new Random();
        return list.get(rdm.nextInt(size));
    }
}