class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] answer = new int[k];
        HashMap<Integer,Integer> myMap = new HashMap<>();
        for(int num:nums){
            int freq = myMap.getOrDefault(num,0);
            myMap.put(num,freq+1);
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(myMap.entrySet());

        list.sort((a,b)->Integer.compare(b.getValue(),a.getValue()));

        for(int i=0;i<k;i++){
            answer[i]=list.get(i).getKey();
        }

        return answer;
    }
} 
