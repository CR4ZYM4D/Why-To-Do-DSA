class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int i = prices.length;
        int j = discounts.length;
        double dissed[] = new double[i];
        while(j-- > 0 && i-- >0){
            dissed[i] = prices[i]* (1-discounts[j]/100.0);
        }
        while(i-->0) dissed[i] = prices[i];
        double total = 0;
        for(double d: dissed) total += d;
        return total;
    }
}