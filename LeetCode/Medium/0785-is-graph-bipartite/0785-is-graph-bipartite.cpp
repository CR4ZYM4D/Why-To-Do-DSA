class Solution {
private:

    bool dfs(int node, vector<int>& colors, int color, vector<vector<int>>& adj){
        colors[node] = color;
        int n = adj[node].size();
        for(int i=0; i<n; i++){
            int neigh = adj[node][i];
            if(colors[neigh] == color) return false;
            if(colors[neigh] == -1){
                if(!dfs(neigh, colors, !color, adj)) return false; 
            }
        }
        return true;
    }

public:
    bool isBipartite(vector<vector<int>>& graph) {
        int n = graph.size();
        vector<int> colors(n, -1);
        for(int i=0; i<n; i++){
            if(colors[i] == -1){
                if(!dfs(i, colors, 0, graph)) return false;
            }
        }
        return true;
    }
};