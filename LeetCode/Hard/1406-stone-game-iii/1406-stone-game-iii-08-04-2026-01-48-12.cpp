class Solution {
public:
    int small = -1e8;
    string stoneGameIII(vector<int>& stoneValue) {
        
        // using bottom up with O(N) space
        int n = stoneValue.size();
        vector<int> dp(n+1, small);
        dp[n] = 0;
        for(int i= n-1; i>-1; i--){

            int take1 = stoneValue[i] - dp[i+1];

            if(i+2<=n){
                int take2 = stoneValue[i] + stoneValue[i+1] - dp[i+2];
                dp[i] = max(dp[i], take2);
            }
            
            if(i+3<=n){
                int take3 = stoneValue[i] + stoneValue[i+1] + stoneValue[i+2] - dp[i+3]; 
                dp[i] = max(dp[i], take3);
            }

            dp[i] = max(dp[i], take1);
        }

        return dp[0] > 0? "Alice" : (dp[0] == 0? "Tie": "Bob");

    }
};