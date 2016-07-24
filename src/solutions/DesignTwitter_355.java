package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://leetcode.com/problems/design-twitter/
 *
 * Design a simplified version of Twitter where users can post tweets,
 * follow/unfollow another user and is able to see the 10 most recent
 * tweets in the user's news feed. Your design should support the
 * following methods:
 *
 * 1. postTweet(userId, tweetId): Compose a new tweet.
 *
 * 2. getNewsFeed(userId): Retrieve the 10 most recent tweet ids in
 * the user's news feed. Each item in the news feed must be posted by
 * users who the user followed or by the user herself. Tweets must be
 * ordered from most recent to least recent.
 *
 * 3. follow(followerId, followeeId): Follower follows a followee.
 *
 * 4. unfollow(followerId, followeeId): Follower unfollows a followee.
 *
 * Example:
 * Twitter twitter = new Twitter();
 *
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 *
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 *
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 *
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 *
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 *
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 *
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 */
public class DesignTwitter_355 {

    public class Twitter {
        private int time;
        private Map<Integer, Set<Integer>> graph;
        private Map<Integer, Tweet> tweets;

        /** Initialize your data structure here. */
        public Twitter() {
            graph = new HashMap<>();
            tweets = new HashMap<>();
            time = 0;
        }

        /** Compose a new tweet. */
        // New user can be created with new userId
        public void postTweet(int userId, int tweetId) {
            Tweet t = new Tweet(tweetId, ++time);
            if (tweets.containsKey(userId)) t.next = tweets.get(userId);
            tweets.put(userId, t);
            graph.putIfAbsent(userId, new HashSet<Integer>());
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> res = new ArrayList<>();
            if (!graph.containsKey(userId)) return res;

            PriorityQueue<Tweet> q = new PriorityQueue<Tweet>((t1, t2) -> t2.time - t1.time);
            if (tweets.containsKey(userId)) q.offer(tweets.get(userId));
            for (int fid : graph.get(userId)) {
                if (tweets.containsKey(fid)) q.offer(tweets.get(fid));
            }
            while (!q.isEmpty() && res.size() < 10) {
                Tweet t = q.poll();
                if (t.next != null) q.offer(t.next);
                res.add(t.id);
            }
            return res;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        // New user can be created with new followerId and followeeId
        public void follow(int followerId, int followeeId) {
            if (followerId == followeeId) return;
            graph.putIfAbsent(followerId, new HashSet<Integer>());
            graph.get(followerId).add(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if (!graph.containsKey(followerId) || !graph.containsKey(followeeId)) return;
            graph.get(followerId).remove(followeeId);
        }

        class Tweet {
            int time; int id; Tweet next;
            public Tweet(int id, int time) {
                this.id = id;
                this.time = time;
            }
        }
    }

    /**
     * Your Twitter object will be instantiated and called as such:
     * Twitter obj = new Twitter();
     * obj.postTweet(userId,tweetId);
     * List<Integer> param_2 = obj.getNewsFeed(userId);
     * obj.follow(followerId,followeeId);
     * obj.unfollow(followerId,followeeId);
     */
}
