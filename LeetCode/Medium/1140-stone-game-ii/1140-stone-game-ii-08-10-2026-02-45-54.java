class Solution {

    int dp[][][];

    public int solve(int[] p, int n, int player, int idx, int m){

        if(idx >= n){
            return 0;
        }

        if(dp[player][idx][m] != -1) return dp[player][idx][m]; 

        int limit = Math.min(2*m, n - idx);
        int result = (player == 0? -1: Integer.MAX_VALUE);
        int stones = 0;

        for(int x=1; x<=limit; x++){

            stones += p[idx+x-1];

            if(player == 0){
                result = Math.max(result,stones + solve(p, n, 1, idx+x, Math.max(m, x)));
            }
            else 
                result = Math.min(result, solve(p, n, 0, idx+x, Math.max(m, x)));
        }

        dp[player][idx][m] = result;

        return dp[player][idx][m];

    }

    public int stoneGameII(int[] piles) {
        
        int n = piles.length;
        dp = new int[2][n][n+1];

        for(int i=0; i<2; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        // 0 for alice 1 for bob
        return solve(piles, n, 0, 0, 1);

    }
}