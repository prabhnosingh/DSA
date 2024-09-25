class Twitter {

    HashMap<Integer, Set<Integer>> following;
    HashMap<Integer, ArrayList<List<Integer>>> postedTweets;

    int count;
    public Twitter() {
        following = new HashMap<>();
        count = 0;
        postedTweets = new HashMap<>();

    }
    
    public void postTweet(int userId, int tweetId) {
        if(!postedTweets.containsKey(userId)){ 
            // try  combination of arraylist and list in list of list and see which works
            postedTweets.put(userId, new ArrayList<List<Integer>>());
        }
        postedTweets.get(userId).add(new ArrayList<>(Arrays.asList(count ++, tweetId)));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> users = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<List<Integer>> tweetQueue = new PriorityQueue<List<Integer>>((List<Integer> l1, List<Integer> l2) -> (l2.get(0) - l1.get(0)));

        users.add(userId);
        if(following.get(userId) != null){
            for(int user : following.get(userId)){
                users.add(user);
            }
        }
        else{
            System.out.println(userId + " does not have any following");
            System.out.println(users);
        }

        for(int id : users){
            ArrayList<List<Integer>> temp = postedTweets.get(id);
            // System.out.println(id + " = id and temp = " + temp);
            if(temp != null){
                for(List<Integer> tweets : temp){
                    tweetQueue.offer(tweets);
                }
            }
        }
        for(int i = 0; i < 10; i ++){
            if(tweetQueue.size() == 0) break;
            List<Integer> tempTweet = tweetQueue.poll();
            ans.add(tempTweet.get(1));
        }
    

        return ans;

        
    }
    
    public void follow(int followerId, int followeeId) {
        // following.put(followerId, following.getOrDefault(followerId, new HashSet<>()).add(followeeId)); -> throws error related to: set.add(followeeId) returns a boolean value whereas .put expects a hashSet as a second parameter. 
        if(!following.containsKey(followerId)){
            following.put(followerId, new HashSet<>());
        }
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(following.get(followerId) != null){
            following.get(followerId).remove(followeeId);
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