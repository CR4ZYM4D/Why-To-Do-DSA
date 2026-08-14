class Solution {
    public int primePalindrome(int n) {
        // Handle small edge cases
        if (n >= 8 && n <= 11) return 11;
        
        // Search odd-length palindromes built from root 'i'
        for (int i = 1; i < 100000; i++) {
            String s = Integer.toString(i);
            StringBuilder sb = new StringBuilder(s);
            String rev = sb.reverse().substring(1); // Drop middle char to keep length odd
            
            int palindrome = Integer.parseInt(s + rev);
            
            if (palindrome >= n && isPrime(palindrome)) {
                return palindrome;
            }
        }
        
        return -1;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}