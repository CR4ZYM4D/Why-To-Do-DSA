class Solution {
    public int minimumDeletions(int[] nums) {
        int minIdx = -1;
        int maxIdx = -1;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(minIdx == -1 || nums[i] < nums[minIdx]) minIdx = i;
            if(maxIdx == -1 || nums[i] > nums[maxIdx]) maxIdx = i;
        } 

        int left = Math.max(minIdx, maxIdx)+1;
        int right = Math.max(n-minIdx, n-maxIdx);

        int alt = Math.min(-minIdx + maxIdx, -maxIdx + minIdx) + n +1;

        return Math.min(Math.min(left, right), alt);
    }
} 