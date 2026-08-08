class Solution {
public:
    vector<int> validSequence(string word1, string word2) {
        
        int l1 = word1.size();
        int l2 = word2.size();

        vector<int> rightMatches(l1, 0);
        int matched = 0;
        int i = l1-1;
        int j = l2-1;

        while(i>-1){
            if(j>=0 && word1[i] == word2[j]){
                j--;
                matched++;
            }
            rightMatches[i] = matched;
            i--;
        }

        bool canChange = true;

        vector<int> seq;
        i = 0;
        j = 0;

        while(i<l1 && j<l2){
            
            if(word1[i] == word2[j]){
                seq.push_back(i);
                j++;
            }
            else if(canChange && i+1 <l1 && rightMatches[i+1] >= l2-1-j){
                seq.push_back(i);
                j++;
                canChange = false;
            }

            i++;
        }

        if(seq.size() == l2) return seq;
        return {};

    }
};