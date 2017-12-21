package leetCode351_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC_355_DesignTwitter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Twitter t=	new Twitter();
		t.postTweet(1, 5);
		t.getNewsFeed(1);
		t.follow(1, 2);
		t.postTweet(2, 6);
		t.getNewsFeed(1);
		t.unfollow(1, 2);
		t.getNewsFeed(1);
	}

	static class News{
		int user;
		int id;
		public News(int u,int i) {
			user =u;
			id = i;
		}
	}
	static class Twitter {

		HashMap<Integer,Set<Integer>> followList;
		ArrayList<News> news;
	    /** Initialize your data structure here. */
	    public Twitter() {
	    	followList = new HashMap<>();
	    	news = new ArrayList<>();
	    }
	    
	    /** Compose a new tweet. */
	    public void postTweet(int userId, int tweetId) {
	        news.add(new News(userId,tweetId));
	    }
	    
	    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
	    public List<Integer> getNewsFeed(int userId) {
	    	List<Integer> res = new ArrayList<>();
	    	Set<Integer> followees = followList.get(userId);
	    	for(int i=news.size()-1,count=0;count<10&&i>=0;i--) {
	    		News temp = news.get(i);
	    		if(followees!=null &&followees.contains(temp.user)||temp.user==userId) {
	    			res.add(temp.id);
	    			count++;
	    		}
	    	}
	    	return res;
	    }
	    
	    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
	    public void follow(int followerId, int followeeId) {
	        if(followList.containsKey(followerId)) {
	        	followList.get(followerId).add(followeeId);
	        }else {
	        	Set<Integer> s = new HashSet<>();
	        	s.add(followeeId);
	        	followList.put(followerId, s);
	        }
	    }
	    
	    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
	    public void unfollow(int followerId, int followeeId) {
	        if(followList.containsKey(followerId)) {
	        	followList.get(followerId).remove(followeeId);
	        }
	    }
	}
}
