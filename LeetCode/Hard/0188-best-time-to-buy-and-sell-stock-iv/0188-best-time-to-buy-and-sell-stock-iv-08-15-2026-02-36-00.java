class Solution {

    public int solve(int[] prices, int len, int[][][] dp, int idx, int sold, int cap){

        if(idx >= len || cap <= 0) return 0;
        if(dp[idx][sold][cap] != -1) return dp[idx][sold][cap];

        if(sold == 0){
            int  buy = -prices[idx] + solve(prices, len, dp, idx+1, 1, cap);
            int skip = solve(prices, len, dp, idx+1, 0, cap);
            dp[idx][sold][cap] = Math.max(buy, skip);
        }

        else{
            int sell = prices[idx] + solve(prices, len, dp, idx+1, 0, cap-1);
            int hold = solve(prices, len, dp, idx+1, 1, cap);

            dp[idx][sold][cap] = Math.max(sell, hold);
        }

        return dp[idx][sold][cap];

    }

    public int maxProfit(int k, int[] prices) {
        
        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];
        for(int[][] arr: dp){
            for(int j[]: arr) Arrays.fill(j, -1);
        }

        return solve(prices, n, dp, 0, 0, k);

    }
}