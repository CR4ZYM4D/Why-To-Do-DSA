class Solution {

    public int solve(int[] prices, int idx, int sold, int cap, int[][][] dp){
        
        if(idx >= prices.length || cap <= 0) return 0;

        if(dp[idx][sold][cap] != -1) return dp[idx][sold][cap];

        if(sold == 0){
            int buy = -prices[idx] + solve(prices, idx+1, 1, cap, dp);
            int skip = solve(prices, idx+1, 0, cap, dp);
            dp[idx][sold][cap] = Math.max(buy, skip);
        }

        else{
            int sell = prices[idx] + solve(prices, idx+1, 0, cap-1, dp);
            int skip = solve(prices, idx+1, 1, cap, dp);
            dp[idx][sold][cap] = Math.max(sell, skip);
        }
        
        return dp[idx][sold][cap];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp table of index, sold, cap 
        int[][][] dp = new int[n][2][3];

        for(int i=0; i<n; i++){
            for(int j[]: dp[i]) Arrays.fill(j, -1);
        }

        return solve(prices, 0, 0, 2, dp);
    }
}