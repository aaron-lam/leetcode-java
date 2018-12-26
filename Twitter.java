import java.util.*;

public class Twitter {
    private Map<Integer, List<Tweet>> tweets; // user id -> user's tweets
    private Map<Integer, Set<Integer>> followees; // user id -> user's followees

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        tweets = new HashMap<>();
        followees = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new LinkedList<>());
        }
        tweets.get(userId).add(0, new Tweet(tweetId));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        Queue<Feed> q = new PriorityQueue<>(Comparator.comparing(f -> -f.curr.order));
        if (tweets.containsKey(userId) && !tweets.get(userId).isEmpty()) {
            q.offer(new Feed(tweets.get(userId)));
        }

        for (Integer followee : followees.getOrDefault(userId, Collections.emptySet())) {
            if (tweets.containsKey(followee) && !tweets.get(followee).isEmpty()) {
                q.offer(new Feed(tweets.get(followee)));
            }
        }

        List<Integer> feeds = new ArrayList<>();
        for (int i = 0; i < 10 && !q.isEmpty(); i++) {
            Feed feed = q.poll();
            feeds.add(feed.curr.id);
            if (feed.advance()) {
                q.offer(feed);
            }
        }

        return feeds;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (!followees.containsKey(followerId)) {
            followees.put(followerId, new HashSet<>());
        }
        followees.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (!followees.containsKey(followerId)) {
            return;
        }
        followees.get(followerId).remove(followeeId);
    }

    private int globalOrder = 0;

    class Tweet {
        private int id;
        private int order;

        public Tweet(int id) {
            this.id = id;
            this.order = globalOrder;
            globalOrder += 1;
        }
    }

    class Feed {
        private Iterator<Tweet> iterator;
        private Tweet curr;

        public Feed(List<Tweet> tweets) {
            iterator = tweets.iterator();
            curr = iterator.next();
        }

        private boolean advance() {
            if (!iterator.hasNext()) {
                return false;
            }
            this.curr = iterator.next();
            return true;
        }
    }
}
