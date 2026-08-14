class Solution {
public:
    int maxProfit(vector<int>& prices) {

        int n = prices.size();
        vector<vector<vector<int>>> dp(n+1, vector<vector<int>>(2, vector<int>(3, -1)));
    
            for(int j=0; j<2; j++){
                for(int k=0; k<3; k++){
                    dp[n][j][k] = 0;
                }
            }

            for(int i=0; i<=n; i++){
                for(int j=0; j<2; j++){
                    dp[i][j][0] = 0;
                }
            }

        for(int i=n-1; i>-1; i--){
            for(int j=0; j<2; j++){
                for(int k = 1; k<3; k++){
                    if(j==0){
                        int buy = -prices[i] + dp[i+1][1][k];
                        int skip = dp[i+1][0][k];
                        dp[i][j][k] = max(buy, skip);
                    }

                    else{
                        int sell = prices[i] + dp[i+1][0][k-1];
                        int skip = dp[i+1][1][k];
                        dp[i][j][k] = max(sell, skip);
                    }

                }
            }
        }

        return dp[0][0][2];
        
    }
};