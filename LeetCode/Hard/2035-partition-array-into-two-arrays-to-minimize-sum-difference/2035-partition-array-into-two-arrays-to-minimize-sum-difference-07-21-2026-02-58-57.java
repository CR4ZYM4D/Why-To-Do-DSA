class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;  // n = 2 * original_n
        int original_n = n / 2;
        
        // Step 1: Split into two halves
        int[] a = Arrays.copyOfRange(nums, 0, n / 2);
        int[] b = Arrays.copyOfRange(nums, n / 2, n);
        
        // Step 2: Generate subset sums grouped by count
        List<List<Integer>> s1 = new ArrayList<>();
        List<List<Integer>> s2 = new ArrayList<>();
        
        // Initialize lists for each possible count
        for (int i = 0; i <= original_n; i++) {
            s1.add(new ArrayList<>());
            s2.add(new ArrayList<>());
        }
        
        // Generate all subset sums with their counts
        subset(s1, a, 0, 0, 0);  // Start: index 0, sum 0, count 0
        subset(s2, b, 0, 0, 0);
        
        // Calculate total sum
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // We want sum1 ≈ totalSum/2
        int half = totalSum / 2;  // Integer division, we handle sign properly
        int ans = Integer.MAX_VALUE;
        
        // Step 3: Try all combinations
        for (int i = 0; i <= original_n; i++) {
            List<Integer> sumsFromFirst = s1.get(i);  // i elements from first half
            List<Integer> sumsFromSecond = s2.get(original_n - i);  // n-i from second half
            
            Collections.sort(sumsFromSecond);
            
            // For each sum from first half
            for (int x : sumsFromFirst) {
                int target = half - x;  // desired sum from second half
                
                // Binary search in second half sums
                int idx = lowerBound(target, sumsFromSecond);
                
                // Check element at idx
                if (idx < sumsFromSecond.size()) {
                    int sum1 = x + sumsFromSecond.get(idx);
                    ans = Math.min(ans, Math.abs(2 * sum1 - totalSum));
                }
                
                // Check element before idx
                if (idx > 0) {
                    int sum1 = x + sumsFromSecond.get(idx - 1);
                    ans = Math.min(ans, Math.abs(2 * sum1 - totalSum));
                }
                
                // Early exit if perfect balance found
                if (ans == 0) return 0;
            }
        }
        
        return ans;
    }
    
    // Binary search: find first index where element >= target
    private int lowerBound(int target, List<Integer> list) {
        int left = 0, right = list.size() - 1;
        int result = list.size();  // default if all elements < target
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    
    // Generate subset sums with count tracking
    private void subset(List<List<Integer>> result, int[] nums, int index, int sum, int count) {
        if (index == nums.length) {
            // Add sum to the list for this count
            result.get(count).add(sum);
            return;
        }
        
        // Option 1: Don't take current element
        subset(result, nums, index + 1, sum, count);
        
        // Option 2: Take current element
        subset(result, nums, index + 1, sum + nums[index], count + 1);
    }
}