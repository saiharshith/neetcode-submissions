class Solution {
    List<List<Integer>> answer;
    private void helper(int[] nums,int index,List<Integer> curr){
        if(index==nums.length){
            answer.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        helper(nums,index+1,curr);
        curr.remove(curr.size()-1);

        int next=index+1;

        while(next<nums.length && nums[next]==nums[index]){
            next++;
        }

        helper(nums,next,curr);
     
        return;   
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        answer = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        helper(nums,0,curr);
        return answer;
    }
}
