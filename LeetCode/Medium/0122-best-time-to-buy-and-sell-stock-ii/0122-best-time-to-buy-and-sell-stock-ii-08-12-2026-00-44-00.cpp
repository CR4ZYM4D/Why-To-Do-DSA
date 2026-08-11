class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        // tabulation approach
        int n = prices.size();
        vector<vector<int>> dp(n+1, vector<int> (2, -1));
        dp[n][0] = 0;
        dp[n][1] = 0;

        for(int i=n-1; i>-1; i--){
            for(int j=0; j<2; j++){

                if(j==0){ // not bought yet
                    // max profit from buying today and selling later
                    int buy = -prices[i] + dp[i+1][1];
                    int skip = dp[i+1][0];
                    dp[i][0] = max(buy, skip);                
                }
                else{
                    int sell = prices[i] + dp[i+1][0];
                    int hold = dp[i+1][1];
                    dp[i][1] = max(sell, hold);
                }

            }
        }
        if(dp[0][0] < 0) return 0;
        return dp[0][0];
    }
};