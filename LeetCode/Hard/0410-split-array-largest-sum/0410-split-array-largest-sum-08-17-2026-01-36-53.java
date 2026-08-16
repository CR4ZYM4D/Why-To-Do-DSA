class Solution {

    public int splitArray(int[] nums, int k) {
        
        int left = 0;
        int right = 0;

        for(int i: nums){
            left = Math.max(left, i);
            right += i;
        }

        while(left < right){
            int mid = (right-left)/2 + left;
            int splits = 1;
            int sum = 0;
            for(int i: nums){
                sum += i;
                if(sum > mid){
                    splits+=1;
                    sum = i;
                }
            }

            if(splits > k) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}