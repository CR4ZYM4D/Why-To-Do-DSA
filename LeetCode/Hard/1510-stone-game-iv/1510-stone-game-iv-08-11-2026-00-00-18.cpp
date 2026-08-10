class Solution {
public:
    bool winnerSquareGame(int n) {
        
        vector<bool> t(n+1, false);
        for(int i=0; i<=n; i++){
            for(int k=1; k*k <= i; k++){
                if(!t[i-k*k]){
                    t[i] = true;
                    break;
                }
            }
        }
        return t[n];
    }
};