class Solution {
public:
    int maxProfit(vector<int>& prices) {

        int n = prices.size();
        vector<vector<int>> dp(n+2, vector<int>(2, 0));
    
        for(int i=n-1; i>-1; i--){
            for(int j=0; j<2; j++){
                if(j == 0){
                    int buy = -prices[i] + dp[i + 1][1];
                    int skip = dp[i + 1][0];
                    dp[i][j] = max(buy, skip);
                }

                else{
                    int sell = prices[i] + dp[i + 2][0];
                    int hold = dp[i + 1][1];
                    dp[i][j] = max(sell, hold);
                }
            }
        }
    return dp[0][0];

    }
};