class Solution {
    static final int INF = (int) 1e9;

    public int solve(int idx, int amount, int[] coins, int[][] dp){

        if(idx == 0){
            if(amount % coins[idx] == 0) return amount / coins[idx];
            return INF;
        }
        if(amount == 0) return 0;
        if(amount < 0) return INF;

        if(dp[idx][amount] != -1) return dp[idx][amount];

        int take = INF;
        if(coins[idx] <= amount){
            int res = solve(idx, amount - coins[idx], coins, dp);
            take = 1 + res;
        }
        int notTake = solve(idx - 1, amount, coins, dp);

        dp[idx][amount] = Math.min(take, notTake);
        return dp[idx][amount];
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);

        int ans = solve(n - 1, amount, coins, dp);
        return ans >= INF ? -1 : ans;
    }
}