class Solution {
    private List<List<Integer>> helper(int[] nums, int index){
        List<List<Integer>> answer = new ArrayList<>();
        if(index == nums.length){
            answer.add(new ArrayList<>());
            return answer ;   
        }

        List<List<Integer>> partial = helper(nums,index+1);

        for(List<Integer> list:partial){
            answer.add(list);
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[index]);
            for(Integer x:list){
                temp.add(x);        
            }
            answer.add(temp);
        } 

        return answer;   
    }
    public List<List<Integer>> subsets(int[] nums) {
        return helper(nums,0);
    }
}
