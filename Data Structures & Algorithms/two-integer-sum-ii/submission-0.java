class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];

        int left=0, right=numbers.length-1;
        int sum; 
        while(left<right){
            sum = numbers[left]+numbers[right];
            if(sum<target)
                left++;
            else if(sum>target)
                right--;
            else{
                ans[0]=left+1;
                ans[1]=right+1;

                return ans;
            }
        }

        return ans;
    }
}
