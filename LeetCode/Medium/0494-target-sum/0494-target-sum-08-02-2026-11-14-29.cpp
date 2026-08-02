class Solution {
public:

    int solve(int idx, int target, int sum, vector<int>& nums, vector<vector<int>>& dp){

        if(idx == 0){
            int count = 0;
            if(target == 0 && nums[idx] == 0) count = 2;
            else if(abs(target) == nums[idx]) count = 1;
            return count;
        }

        if(dp[idx][target + sum] != -1) return dp[idx][target + sum];

        int positive = 0, negative = 0;
        if(abs(target - nums[idx]) <= abs(sum)){
            positive = solve(idx -1, target - nums[idx], sum, nums, dp);
        }

        if(abs(target + nums[idx]) <= abs(sum)){
            negative = solve(idx -1, target + nums[idx], sum, nums, dp);
        }

        dp[idx][target + sum] = positive + negative;

        return dp[idx][target + sum];

    }

    int findTargetSumWays(vector<int>& nums, int target) {
        int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);
        if(target > sum || target < -sum) return 0;

        vector<vector<int>> dp(n, vector<int>(2*sum+1, -1));
        return solve(n-1, target, sum, nums, dp);
    }
};