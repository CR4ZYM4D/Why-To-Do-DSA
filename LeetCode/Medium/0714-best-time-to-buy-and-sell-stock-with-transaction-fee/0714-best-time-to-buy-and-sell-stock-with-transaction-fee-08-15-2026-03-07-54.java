class Solution {

    public int solve(int[] prices, int[][] dp, int n, int fee, int i, int s){

        if(i >= n) return 0;
        if(dp[i][s] != -1) return dp[i][s];

        if(s == 0){
            int buy = -prices[i] + solve(prices, dp, n, fee, i+1, 1);
            int skip = solve(prices, dp, n, fee, i+1, 0);
            dp[i][s] = Math.max(buy, skip);
        }

        else{
            int sell = prices[i] - fee + solve(prices, dp, n, fee, i + 1, 0);
            int hold = solve(prices, dp, n, fee, i+1, 1);
            dp[i][s] = Math.max(sell, hold);
        }

        return dp[i][s];

    }

    public int maxProfit(int[] prices, int fee) {
        
        int n = prices.length;
        int dp[][] = new int[n][2];

        for(int[] arr: dp) Arrays.fill(arr, -1);

        return solve(prices, dp, n, fee, 0, 0);

    }
}