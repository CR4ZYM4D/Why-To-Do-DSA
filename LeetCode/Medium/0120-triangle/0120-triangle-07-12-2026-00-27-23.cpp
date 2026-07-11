class Solution {
public:
    int minimumTotal(vector<vector<int>>& list) {
        int n = list.size();
        for(int i=n-2; i>-1; i--){
            for(int j=0; j<list[i].size(); j++){
                int right = list[i+1][j+1];
                int down = list[i+1][j];
                list[i][j] += min(down, right);
            }
        }
        return list[0][0];
    }
};