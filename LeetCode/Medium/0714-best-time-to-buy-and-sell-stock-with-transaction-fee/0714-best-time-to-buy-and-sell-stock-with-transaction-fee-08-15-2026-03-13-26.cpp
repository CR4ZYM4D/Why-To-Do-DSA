class Solution {
public:
    int maxProfit(vector<int>& prices, int fee) {

        int n = prices.size();
        vector<vector<int>> dp(n+1, vector<int>(2, 0));
    
        for(int i=n-1; i>=0; i--){
            for(int s=1; s>-1; s--){

                if(s == 0){
                    int buy = -prices[i] + dp[i+1][1];
                    int skip = dp[i+1][0];
                    dp[i][s] = max(buy, skip);
                }

                else{
                    int sell = prices[i] - fee + dp[i + 1][0];
                    int hold = dp[i+1][1];
                    dp[i][s] = max(sell, hold);
                }

            }
        }
        return dp[0][0];
    }
};