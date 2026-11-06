
class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // Target must be within the possible range
        if (Math.abs(target) > sum) {
            return 0;
        }

        // S + target must be even
        if ((sum + target) % 2 != 0) {
            return 0;
        }

        int subsetSum = (sum + target) / 2;

        int n = nums.length;

        // dp[i][s] = number of ways to form sum s
        // using the first i elements
        int[] dp = new int[subsetSum + 1];

        // Base case: one way to form sum 0 using no elements
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int s = subsetSum; s >=nums[i-1]; s--) {

                // Include current element if possible
                if (nums[i - 1] <= s) {
                    dp[s] += dp[s - nums[i - 1]];
                }
            }
        }

        return dp[subsetSum];
    }
}
