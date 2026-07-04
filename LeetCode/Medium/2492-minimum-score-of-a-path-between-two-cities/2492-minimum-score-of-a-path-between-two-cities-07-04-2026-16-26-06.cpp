class Solution {
public:
    int minScore(int n, vector<vector<int>>& roads) {
        vector<vector<pair<int, int>>> adj(n+1);
        vector<bool> visited(n+1, false);
        for(vector<int>&  i: roads){
            adj[i[0]].push_back({i[1], i[2]});
            adj[i[1]].push_back({i[0], i[2]});
        }

        queue<int> dq;
        dq.push(1);
        int minDist = INT_MAX;
        while(!dq.empty()){
            int city = dq.front();
            dq.pop();
            if(!visited[city]){
                visited[city] = true;
                for(pair<int, int>& arr: adj[city]){
                    int c2 = arr.first;
                    int d = arr.second;
                    if(d<minDist) minDist = d;
                    if(!visited[c2]) dq.push(c2);
                }
            }
        }
        return minDist;
    }
};