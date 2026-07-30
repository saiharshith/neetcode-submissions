class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp;

        Arrays.sort(nums);
        int left,right,target,sum;
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            left=i+1;
            right=nums.length-1;
            target=-nums[i];
            while(left<right){
                sum=nums[left]+nums[right];
                if(sum<target)
                    left++;
                else if(sum>target)
                    right--;
                else{
                    temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);

                    ans.add(temp);

                    left++;
                    right--;

                    while(left<right && nums[left]==nums[left-1])
                        left++;
                    while(left<right && nums[right]==nums[right+1])
                        right--;
                }
            }
        }

        return ans;
        
    }
}
