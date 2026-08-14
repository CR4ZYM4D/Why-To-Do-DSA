class Solution {

    int solve(int[] prices, int[][] dp, int maxLen, int idx, int sold){
        
        if(idx >= maxLen) return 0;
        if(dp[idx][sold] != -1) return dp[idx][sold];

        if(sold == 0){
            int buy = -prices[idx] + solve(prices, dp, maxLen, idx + 1, 1);
            int skip = solve(prices, dp, maxLen, idx+1, 0);
            dp[idx][sold] = Math.max(buy, skip);
        }

        else{
            int sell = prices[idx] + solve(prices, dp, maxLen, idx + 2, 0);
            int hold = solve(prices, dp, maxLen, idx + 1, 1);
            dp[idx][sold] = Math.max(sell, hold);
        }

        return dp[idx][sold]; 
    }

    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int arr[]: dp)Arrays.fill(arr, -1);

        return solve(prices, dp, n, 0, 0);

    }
}