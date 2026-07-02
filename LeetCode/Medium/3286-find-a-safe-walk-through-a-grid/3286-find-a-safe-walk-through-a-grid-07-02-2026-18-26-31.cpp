class Solution {
public:
    bool findSafeWalk(vector<vector<int>>& grid, int health) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> coords = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        vector<vector<int>> visited(m, vector<int>(n, INT_MAX));
        deque<pair<int, int>> dq;

        dq.push_back({0, 0});
        visited[0][0] = grid[0][0];

        while(!dq.empty()){

            int r = dq.front().first;
            int c = dq.front().second;
            dq.pop_front();
            for(auto& i: coords){
                int nd = visited[r][c];
                int r1 = r + i[0];
                int c1 = c + i[1];
                if(r1<0 || r1>=m || c1<0 || c1>=n) continue;
                int w = grid[r1][c1];
                nd += w;
                if(nd < visited[r1][c1]){
                    visited[r1][c1] = nd;
                    if(w == 0) dq.push_front({r1, c1});
                    else dq.push_back({r1, c1});
                } 
            }
        }
        return visited[m-1][n-1] < health;
    }
};