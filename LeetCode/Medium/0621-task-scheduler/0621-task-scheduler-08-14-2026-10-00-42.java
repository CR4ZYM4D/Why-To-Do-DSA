class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int count[] = new int[26];
        int maxFreq = 0;
        int maxCount = 0;

        int time = 0;

        for(char c: tasks){
            int i = c-65;
            count[i]++;
            if(count[i] == maxFreq) maxCount++;
            else if(count[i] > maxFreq){
                maxCount = 1;
                maxFreq = count[i];
            }
        }

        int numParts = maxFreq - 1;
        int partLength = n - maxCount + 1;
        int totalEmpty = partLength * numParts;

        int leftEmpty = Math.max(0, totalEmpty - tasks.length + maxCount * maxFreq);
        return tasks.length + leftEmpty;
    
    }
}