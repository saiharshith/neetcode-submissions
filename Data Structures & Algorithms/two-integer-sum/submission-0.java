class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> myMap = new HashMap<>();

        int[] ans = new int[2];

        for(int i=0;i<nums.length;i++){
            if(myMap.containsKey(target-nums[i])){
                ans[0]=myMap.get(target-nums[i]);
                ans[1]=i;

                return ans;
            }
            myMap.put(nums[i],i);
        }

        return ans;    
    }
}
