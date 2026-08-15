class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if(nums[n-1] == 0) return 0;
        int tot = 0;
        for(int i: nums) tot ^= i;

        return tot == 0? n-1: n;
    }
}