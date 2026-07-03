class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        int n = grid.size();
        vector<vector<int>> visited(n, vector<int>(n, INT_MAX));
        vector<vector<int>> coords = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        queue<pair<int, int>> dq;
        if(grid[0][0] == 0) dq.push({0, 0});
        visited[0][0] = 1;
        while(!dq.empty()){
            pair<int, int> rc = dq.front();
            dq.pop();
            int r = rc.first;
            int c = rc.second;
            if(r==n-1 && c==n-1) return visited[r][c];
            for(vector<int>& i: coords){
                int r1 = r + i[0];
                int c1 = c + i[1];
                if(r1<0 || c1<0 || r1>=n || c1>=n || visited[r1][c1]!=INT_MAX || grid[r1][c1]==1) continue;
                visited[r1][c1] = visited[r][c] + 1; 
                dq.push({r1, c1});
            }
        }
        return -1;
    }
};