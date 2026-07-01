class Solution {
private:
    bool kahnAlgo(vector<vector<int>>& adj, vector<int>& indegree, int n){
        int count = 0;
        deque<int> dq;
        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                dq.push_back(i);
                count++;
            }
        }
        while(!dq.empty()){
            int node = dq.front();
            dq.pop_front();
            for(int i=0; i<adj[node].size(); i++){
                indegree[adj[node][i]]--;
                if(indegree[adj[node][i]] == 0){dq.push_back(adj[node][i]); count++;}
            }
        }
        return count == n;
    }
public:
    bool canFinish(int n, vector<vector<int>>& pre) {
        
        // use topo sort with kahns algo
        vector<int> indegree(n, 0);
        vector<vector<int>> adj(n, vector<int>());
        for(vector<int>& i: pre){
            adj[i[1]].push_back(i[0]);
            indegree[i[0]]++;
        }

        return kahnAlgo(adj, indegree, n);        

    }
};