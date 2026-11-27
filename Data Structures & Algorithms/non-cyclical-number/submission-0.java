class Solution {
    private boolean helper(int n, HashSet<Integer> visited){
        if(n==1){
            return true;
        }
        if(visited.contains(n)){
            return false;
        }
        visited.add(n);
        int sum=0;

        while(n>0){
            int digit=n%10;
            sum+=digit*digit;
            n/=10;
        }

         return helper(sum,visited);   
    }
    public boolean isHappy(int n) {
        HashSet<Integer> visited = new HashSet<>();
        return helper(n,visited);
    }
}
