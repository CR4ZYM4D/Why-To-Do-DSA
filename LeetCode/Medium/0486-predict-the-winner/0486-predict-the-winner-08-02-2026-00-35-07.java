class Solution {

    public int findMaxSum(int[] nums, int si, int ei, int[][] table){

        if(si>ei) return 0;
        if(si==ei) return nums[si];

        if(table[si][ei] != -1) return table[si][ei];

        int sum1 = nums[si] + Math.min(findMaxSum(nums, si+2, ei, table), findMaxSum(nums, si+1, ei-1, table));
        int sum2 = nums[ei] + Math.min(findMaxSum(nums, si, ei-2, table), findMaxSum(nums, si+1, ei-1, table));
        table[si][ei] = Math.max(sum1, sum2);
        return table[si][ei];

    }

    public boolean predictTheWinner(int[] nums) {
        
        int totalSum = 0;
        for(int i: nums) totalSum += i;
        
        int si = 0;
        int ei = nums.length-1;
        if(nums.length == 1) return true;
        
        int table[][] = new int[ei+1][ei+1];
        for(int[] arr: table) Arrays.fill(arr, -1);

        int sum = findMaxSum(nums, si, ei, table);
        return sum >= (totalSum - sum);

    }
}