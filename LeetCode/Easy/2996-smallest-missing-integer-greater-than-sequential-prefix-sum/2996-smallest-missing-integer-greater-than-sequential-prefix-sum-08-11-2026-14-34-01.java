class Solution {
    public int missingInteger(int[] nums) {
        
        int prev = nums[0];
        int sum = prev;
        Set<Integer> set = new HashSet<>();

        for(int i: nums) set.add(i);

        for(int i=1; i<nums.length; i++){
            if(nums[i]-prev == 1){
                sum+=nums[i];
                prev = nums[i];
            }
            else break;
        }

        while(set.contains(sum)) sum+=1;

        return sum;

    }
}