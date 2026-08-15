class Solution {
public:
    int longestSubsequence(vector<int>& nums) {
        
        int tot = 0;
        for(int i: nums) tot ^= i;
        int n = nums.size();

        if(tot != 0) return n;
        sort(nums.begin(), nums.end());

        if(nums[n-1] == 0) return 0;
        return n-1;        

    }
};