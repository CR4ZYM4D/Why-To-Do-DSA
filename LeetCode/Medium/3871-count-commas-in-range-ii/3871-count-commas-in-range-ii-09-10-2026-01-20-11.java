class Solution {
    public long countCommas(long n) {
        
        long ans = 0;

        for(int i=3; i<=15; i+=3){
            long dig = (long)(Math.pow(10, i));
            if(dig>n) return ans;
            ans += (n-dig + 1);
        }
        return ans;
    }
}