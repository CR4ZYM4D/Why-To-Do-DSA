class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        
        int n = graph.size();
        vector<vector<int>> adj(n, vector<int>());

        vector<int> res;
        deque<int> dq;
        vector<int> inDegree(n, 0);

        for(int i=0; i<n; i++){
            for(int j: graph[i]){
                adj[j].push_back(i);
                inDegree[i]++;
            }
        }

        for(int i=0; i<n; i++){
            if(inDegree[i]== 0)dq.push_back(i);
        }

        while(!dq.empty()){
            int node = dq.front();
            dq.pop_front();
            res.push_back(node);
            for(int i: adj[node]){
                inDegree[i]--;
                if(inDegree[i]== 0) dq.push_back(i);
            }
        }
        std::sort(res.begin(), res.end());
        return res;
    }
};