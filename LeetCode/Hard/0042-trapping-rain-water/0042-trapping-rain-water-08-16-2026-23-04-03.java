class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        int next[] = new int[n];
        int prev[] = new int[n];

        prev[0] = -1;
        next[n-1] = -1;
        int prevG = height[0];
        int nextG = height[n-1];
        for(int i=1; i<n; i++){
            prevG = Math.max(prevG, height[i]);
            prev[i] = prevG;
        }
        
        for(int i= n-2; i>-1; i--){
            nextG = Math.max(nextG, height[i]);
            next[i] = nextG;
        }

        int total = 0;
        for(int i=0; i<n; i++){
            total += Math.max(0, Math.min(prev[i], next[i]) - height[i]);
        }
        return total;

    }
}