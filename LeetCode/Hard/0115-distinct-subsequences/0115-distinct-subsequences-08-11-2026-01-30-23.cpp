using ui = unsigned int;

class Solution {
public:
    int numDistinct(string s, string t) {
        int n = s.length();
        int m = t.size(); 
        
        // 1 based indexing of string
        vector<vector<ui>> dp(n+1, vector<ui> (m+1, 0));

        // if t has been exhaustwed there can only be one subseq for remaining char of i taking none of them
        for(int i=0; i<=n; i++) dp[i][0] = 1;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){

                if(s[i-1] == t[j-1])
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1]; //i-1, j when we dont take index i-1 and j-1 when we do

                else dp[i][j] = dp[i-1][j]; // no match so we cant take

            }
        }

        return dp[n][m];


    }
};