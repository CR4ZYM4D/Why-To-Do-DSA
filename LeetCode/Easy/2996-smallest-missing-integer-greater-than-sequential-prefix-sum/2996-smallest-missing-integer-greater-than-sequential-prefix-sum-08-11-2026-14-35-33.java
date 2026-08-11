class Solution {
    public int missingInteger(int[] nums) {
        
        int prev = nums[0];
        int sum = prev;
        Set<Integer> set = new HashSet<>();

        set.add(nums[0]);
        boolean flag = true;

        for(int i=1; i<nums.length; i++){
            if(flag && nums[i]-prev == 1){
                sum+=nums[i];
                prev = nums[i];
            }
            else{flag = false;}
            set.add(nums[i]);
        }

        while(set.contains(sum)) sum+=1;

        return sum;

    }
}