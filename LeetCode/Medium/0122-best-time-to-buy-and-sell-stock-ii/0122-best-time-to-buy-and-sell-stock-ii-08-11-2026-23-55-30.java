class Solution{

    public int solve(int[] prices, int[][] dp, int idx, int max, int held){
        
        if(idx == max) return 0;
        if(dp[idx][held] != -1) return dp[idx][held];

        if(held == 0){
            int buy = -prices[idx] + solve(prices, dp, idx+1, max, 1);
            int skip = solve(prices, dp, idx+1, max, 0);
            dp[idx][held] = Math.max(buy, skip);
        }

        else{
            int sell = prices[idx] + solve(prices, dp, idx+1, max, 0);
            int hold = solve(prices, dp, idx+1, max, 1);
            dp[idx][held] = Math.max(sell, hold);
        }

        return dp[idx][held];

    }

    public int maxProfit(int[] prices){

        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int arr[]: dp) Arrays.fill(arr, -1);

        int profit = solve(prices, dp, 0, n, 0);

        return profit > 0? profit: 0 ;
    }

}