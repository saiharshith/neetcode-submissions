class Solution {
    List<List<Integer>> answer;
    List<Integer> unique;
    HashMap<Integer,Integer> myMap; 
    private void helper(int index,int target,List<Integer> curr){
        if(target==0){
            answer.add(new ArrayList<>(curr));
            return;    
        }
        if(target<0 || index==unique.size()){
            return;
        }
        int currentVal = unique.get(index);
        if(myMap.get(currentVal)>0){
            curr.add(currentVal);
            myMap.put(currentVal,myMap.get(currentVal)-1);
            helper(index,target-currentVal,curr);
            myMap.put(currentVal,myMap.get(currentVal)+1);
            curr.remove(curr.size()-1);    
        } 

        helper(index+1,target,curr);   
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        answer = new ArrayList<>();
        myMap = new HashMap<>();
        unique = new ArrayList<>();

        List<Integer> curr = new ArrayList<>();

        for(int x: candidates){
            if(!myMap.containsKey(x)){
                unique.add(x);
            }
            myMap.put(x,myMap.getOrDefault(x,0)+1);
        }

        helper(0,target,curr);

        return answer;
    }
}
