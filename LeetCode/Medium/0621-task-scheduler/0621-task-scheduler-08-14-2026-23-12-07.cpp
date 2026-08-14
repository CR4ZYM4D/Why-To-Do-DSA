class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        
        int l = tasks.size();
        int maxCount = 0;
        int maxFreq = 0;
        vector<int> task(26, 0);

        for(char c: tasks){
            task[c-'A']++;
            if(task[c-'A'] == maxFreq){maxCount++;}
            else if(task[c-'A'] > maxFreq){
                maxFreq = task[c-'A'];
                maxCount = 1;
            }
        } 

        int numParts = maxFreq - 1;
        int partLength = n - (maxCount - 1);
        
        int totalEmpty = numParts * partLength;
        int actualEmpty = totalEmpty - (l - maxCount * maxFreq);

        int left = max(0, actualEmpty);
        return l + left;

    }
};