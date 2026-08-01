class Solution {
public:

    int solve(vector<int>& nums, vector<vector<int>>& dp, int i, int j){
        if(i==j) return nums[i];
        if(i>j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int sum1 = nums[i] + min(solve(nums, dp, i+2, j), solve(nums,dp,i+1, j-1));
        int sum2 = nums[j] + min(solve(nums, dp, i, j-2), solve(nums,dp,i+1, j-1));

        return dp[i][j] = max(sum1, sum2);

    }

    bool predictTheWinner(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(n, -1));
        int totalSum = accumulate(nums.begin(), nums.end(), 0);
        int sum = solve(nums, dp, 0, n-1);
        return sum >= totalSum -sum;
    }
};