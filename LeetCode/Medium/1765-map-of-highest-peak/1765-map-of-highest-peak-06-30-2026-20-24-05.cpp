class Solution {
public:
    vector<vector<int>> highestPeak(vector<vector<int>>& mat) {
       
       vector<int> rows= {-1, 1, 0 , 0};
       vector<int> cols= {0, 0, -1 , 1};
        int m = mat.size();
        int n = mat[0].size();
        vector<vector<int>> dist(m, vector<int>(n, -1));
        deque<pair<int, int>> dq;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1){
                    dq.push_back({i, j});
                    dist[i][j] = 0;
                }
            }
        }

        int steps = 1;

        while(!dq.empty()){
            
            int l = dq.size();
            while(l--){
                pair<int, int> arr = dq.front();
                dq.pop_front();
                for(int i=0; i<4; i++){
                    int r = arr.first + rows[i];
                    int c = arr.second + cols[i];

                    if(r<0 || r>=m || c<0 || c>=n || dist[r][c] != -1) continue;

                    dist[r][c] = steps;
                    dq.push_back({r, c});
                }
            }
            steps++;
        }
        return dist;

    }
};