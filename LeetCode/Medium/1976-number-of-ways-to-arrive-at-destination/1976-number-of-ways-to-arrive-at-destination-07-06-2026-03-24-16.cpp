using ll = long long ;

class Solution {
public:
    int countPaths(int n, vector<vector<int>>& roads) {
        const int modulo = 1e9 + 7; 
        vector<pair<ll, ll>> adj[n];
        vector<ll> dist(n, LLONG_MAX);
        vector<ll> ways(n, 0);
        dist[0]= 0;
        ways[0] = 1;

        for(vector<int>& i: roads){
            int c1 = i[0];
            int c2 = i[1];
            int cost = i[2];

            adj[c1].push_back({cost, c2});
            adj[c2].push_back({cost, c1});
        }

        priority_queue<pair<ll, ll>, vector<pair<ll, ll>>, greater<pair<ll, ll>>> pq;

        pq.push({0, 0});
        while(!pq.empty()){
            
            ll city = pq.top().second;
            ll cost = pq.top().first;
            pq.pop();
            if(cost > dist[city]) continue;
            for(auto& i: adj[city]){
                ll wt = i.first;
                ll neigh = i.second;
                if(wt + cost < dist[neigh]){
                    dist[neigh] = wt + cost;
                    ways[neigh] = ways[city];
                    pq.push({wt+cost, neigh});
                }
                else if(wt + cost == dist[neigh]){
                    ways[neigh] = (ways[neigh] + ways[city])%modulo;
                }
            }
        }
        return (int)(ways[n-1]%modulo);
    }
};