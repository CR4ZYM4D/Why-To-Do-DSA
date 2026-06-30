class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        
        vector<vector<int>> coords = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = mat.size();
        int n = mat[0].size();
        vector<vector<int>> dist(m, vector<int>(n));
        vector<vector<bool>> visited(m, vector<bool>(n));
        deque<vector<int>> dq;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!mat[i][j]){
                    dq.push_back({i, j});
                    visited[i][j] = true;
                }
            }
        }

        int steps = 1;

        while(!dq.empty()){
            
            int l = dq.size();
            while(l--){
                vector<int> arr = dq.front();
                dq.pop_front();
                for(auto& i: coords){
                    int r = arr[0] + i[0];
                    int c = arr[1] + i[1];

                    if(r<0 || r>=m || c<0 || c>=n || visited[r][c]) continue;
                    visited[r][c] = true;
                    dist[r][c] = steps;
                    dq.push_back({r, c});
                }
            }
            steps++;
        }
        return dist;
    }
};