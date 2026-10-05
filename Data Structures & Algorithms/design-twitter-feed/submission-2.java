class Twitter {
    class Tweet{
        int tweetId;
        int timestamp;

        Tweet(int id,int timestamp){
            this.tweetId = id;
            this.timestamp = timestamp;    
        }
    }

    class TweetNode{
        int userId;
        int index;

        TweetNode(int userId, int index){
            this.userId = userId;
            this.index = index;
        }
    }

    Map<Integer,HashSet<Integer>> followMap;
    Map<Integer, List<Tweet>> tweetsMap;

    int globalTime; 

    public Twitter() {
        followMap = new HashMap<>();
        tweetsMap = new HashMap<>();
        globalTime = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId,globalTime++);

        tweetsMap.computeIfAbsent(userId,k->new ArrayList<>()).add(newTweet);            
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> answer = new ArrayList<>();
        PriorityQueue<TweetNode> pq =  new PriorityQueue<>((a,b)->Integer.compare(tweetsMap.get(b.userId).get(b.index).timestamp,tweetsMap.get(a.userId).get(a.index).timestamp));
        
        if(tweetsMap.containsKey(userId) && tweetsMap.get(userId).size()>0){
            pq.add(new TweetNode(userId,tweetsMap.get(userId).size()-1));
        }

        HashSet<Integer> temp = followMap.getOrDefault(userId,null);

        if(temp!=null){
            for(Integer user:temp){
                if(tweetsMap.containsKey(user) && tweetsMap.get(user).size()>0){
                    pq.add(new TweetNode(user,tweetsMap.get(user).size()-1));
                }    
            }
        }

        int count =0;
        while(count<10 && !pq.isEmpty()){
            TweetNode tempNode = pq.poll();
            answer.add(tweetsMap.get(tempNode.userId).get(tempNode.index).tweetId);
            if(tempNode.index>0){
                pq.offer(new TweetNode(tempNode.userId,tempNode.index-1));
            }
            count++;
        }

        return answer; 
    }
    
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> temp = followMap.getOrDefault(followerId, new HashSet<>());
        temp.add(followeeId);
        followMap.put(followerId,temp);    
    }
    
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> temp = followMap.getOrDefault(followerId, new HashSet<>());
        temp.remove(followeeId);
        followMap.put(followerId,temp);     
    }
}
