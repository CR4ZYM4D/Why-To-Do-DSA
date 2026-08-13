class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int i = prices.length;
        int j = discounts.length;
        
        double total = 0;
        
        while(j-- > 0 && i-->0){
            total += prices[i]* (1-discounts[j]/100.0);
        }
        while(i-->0) total += prices[i];
        
        return total;
    }
}