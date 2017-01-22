package course1;

import java.util.ArrayList;
import java.util.List;

public class MiniTwitter {
	
	public MiniTwitter() {
        // initialize your data structure here.
    }

    // @param user_id an integer
    // @param tweet a string
    // return a tweet
    public Tweet postTweet(int user_id, String tweet_text) {
        //  Write your code here
    	Tweet tweet = new Tweet();
    	return tweet;
    }

    // @param user_id an integer
    // return a list of 10 new feeds recently
    // and sort by timeline
    public List<Tweet> getNewsFeed(int user_id) {
        // Write your code here
    	List<Tweet> list = new ArrayList<Tweet> ();
    	
    	return list;
    }
        
    // @param user_id an integer
    // return a list of 10 new posts recently
    // and sort by timeline
    public List<Tweet>  getTimeline(int user_id) {
        // Write your code here
    	List<Tweet> list = new ArrayList<Tweet> ();
    	
    	return list;
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        // Write your code here
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        // Write your code here
    }
	
	
	private class Tweet {
	    public int id;
	    public int user_id;
	    public String text;
	    public Tweet create(int user_id, String tweet_text) {
	        // This will create a new tweet object,
	        // and auto fill id
	    	return new Tweet();
	    }
	}
}
