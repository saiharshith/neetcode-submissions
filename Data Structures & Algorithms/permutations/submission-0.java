class Solution {
    List<List<Integer>> answer;
    HashSet<Integer> mySet;
    private void helper(int[] nums, List<Integer> curr){
        if(curr.size()==nums.length){
            answer.add(new ArrayList<>(curr));
            return;
        }

        for(int x:nums){
            if(!mySet.contains(x)){
                curr.add(x);
                mySet.add(x);
                helper(nums,curr);
                curr.remove(curr.size()-1);
                mySet.remove(x);    
            }
        }    
            
    }
    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        mySet = new HashSet<>();
        List<Integer> curr = new ArrayList<>();
        helper(nums,curr);
        return answer;
    }
}
