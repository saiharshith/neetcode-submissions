class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
            return 0;
        int max=1;

        HashSet<Integer> mySet = new HashSet<>();

        for(int num:nums){
            mySet.add(num);
        }

        for(int num:nums){
            if(!mySet.contains(num-1)){
                for(int i=1;i<=nums.length;i++){
                    if(!mySet.contains(num+i)){
                        if(max<i)
                            max=i;
                        break;
                    }
                }
            }
        }

        return max;
        
    }
}
