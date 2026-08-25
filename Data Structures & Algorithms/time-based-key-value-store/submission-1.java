class TimeMap {

    static class Pair{
        int timestamp;
        String value;

        Pair(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    Map<String,List<Pair>> myMap;

    public TimeMap() {
        myMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> tempList = myMap.getOrDefault(key,new ArrayList<>());
        tempList.add(new Pair(timestamp, value));
        myMap.put(key,tempList);    
    }
    
    public String get(String key, int timestamp) {
        if(!myMap.containsKey(key))
            return "";

        List<Pair> tempList = myMap.get(key);
        if(timestamp<tempList.get(0).timestamp)
            return "";
        if(timestamp>tempList.get(tempList.size()-1).timestamp)
            return tempList.get(tempList.size()-1).value;

        int left = 0, right = tempList.size()-1;

        int index=-1;

        while(left<=right){
            int mid = left + (right-left)/2;
            if(tempList.get(mid).timestamp==timestamp){
                return tempList.get(mid).value;
            }

            if(tempList.get(mid).timestamp>timestamp){
                right=mid-1;
            }else{
                index=mid;
                left=mid+1;
            }
        }

        if(index==-1)
            return "";

        return tempList.get(index).value;

    }
}
