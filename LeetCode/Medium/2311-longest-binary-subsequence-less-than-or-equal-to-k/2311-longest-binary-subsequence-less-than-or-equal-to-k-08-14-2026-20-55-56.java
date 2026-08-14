class Solution {

    public int longestSubsequence(String s, int k) {
        int val = 0;
        int length = 0;
        int pow = 1; // 2^0, 2^1, 2^2...

        // Iterate right-to-left
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == '0') {
                length++; // Zeros are always free to include
            } else {
                // For '1', only include it if it fits within k
                if (pow <= k && val + pow <= k) {
                    val += pow;
                    length++;
                }
            }

            // Prevent integer overflow for pow when shifting left
            if (pow <= k) {
                pow *= 2;
            }
        }

        return length;
    }
}