class Solution {

    static final int min = (int)-1e8;

    public int solve(int idx, int[] stones, int[] dp, int n){
        
        if(idx >= n) return 0;
        if(dp[idx] > min) return dp[idx];

        int take1 = stones[idx] - solve(idx+1, stones, dp, n);
        int take2 = min, take3 = min;

        if(idx+1 < n)
            take2 = stones[idx] + stones[idx+1] -solve(idx+2, stones, dp, n);

        if(idx+2 < n)
            take3 = stones[idx]+ stones[idx+1] + stones[idx+2] - solve(idx+3, stones, dp, n);

        dp[idx] = Math.max(take1, Math.max(take2, take3));

        return dp[idx];
    }

    public String stoneGameIII(int[] stoneValue) {
        
        // using recursion + memoization

        int dp[] = new int[stoneValue.length];
        Arrays.fill(dp, min);
        int diff = solve(0, stoneValue, dp, stoneValue.length);
        
        return diff>0? "Alice" : (diff == 0 ? "Tie" : "Bob");
    }
}