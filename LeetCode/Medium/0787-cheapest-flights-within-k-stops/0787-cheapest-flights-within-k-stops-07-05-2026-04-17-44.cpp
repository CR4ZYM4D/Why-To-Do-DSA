class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {

        // dist, {city, steps}
        priority_queue<pair<int,pair<int,int>>, vector<pair<int,pair<int,int>>>, greater<pair<int,pair<int,int>>>> pq;
        vector<int> stops(n, INT_MAX);
        vector<vector<pair<int, int>>> adj(n, vector<pair<int, int>>());
        for(auto& i: flights){
            adj[i[0]].push_back({i[2], i[1]});
        } 

        stops[src] = 0;
        pq.push({0, {src, 0}});
        while(!pq.empty()){
            pair<int, pair<int, int>> i = pq.top();
            pq.pop();
            int d = i.first;
            int city = i.second.first;
            int s = i.second.second;
            if(city == dst) return d;
            if(s > k || stops[city] < s) continue;
            stops[city] = s;
            for(auto& i: adj[city]){
                int dist = d + i.first;
                int c1 = i.second; 
                pq.push({dist, {c1, s+1}});
            }
        }
        return -1;
    }
};