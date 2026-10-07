class Solution {
    List<List<Integer>> answer;
    private void helper(int[] nums, int index, int target,List<Integer> curr){
        if(target==0){
            answer.add(new ArrayList<>(curr));
            return;
        }

        if(target<0 || index==nums.length){
            return;
        }

        curr.add(nums[index]);
        helper(nums,index,target-nums[index],curr);
        curr.remove(curr.size()-1);

        helper(nums,index+1,target,curr);

    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        answer = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(nums,0,target,curr);
        return answer;
    }
}
