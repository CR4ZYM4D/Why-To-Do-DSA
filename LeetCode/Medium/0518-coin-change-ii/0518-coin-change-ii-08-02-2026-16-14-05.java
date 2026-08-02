class Solution {

    public int solve(int idx, int target, int[] nums, int[][] dp){

        if(idx == 0){ 
            if(target % nums[0] == 0) return 1;
            return 0;
        }

        if(dp[idx][target] != -1) return dp[idx][target];

        int take = 0;
        if(nums[idx] <= target) take = solve(idx, target-nums[idx], nums, dp);

        int notTake = solve(idx-1, target, nums, dp);

        dp[idx][target] = take + notTake;
        return dp[idx][target];

    }

    public int change(int amount, int[] coins) {
        
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];

        for(int arr[]: dp) Arrays.fill(arr, -1);

        return solve(n-1, amount, coins, dp);

    }
}