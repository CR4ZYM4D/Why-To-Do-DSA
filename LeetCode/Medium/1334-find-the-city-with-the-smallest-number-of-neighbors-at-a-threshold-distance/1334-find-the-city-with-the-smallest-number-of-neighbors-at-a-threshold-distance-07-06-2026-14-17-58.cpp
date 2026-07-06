class Solution {
public:
    int findTheCity(int n, vector<vector<int>>& edges, int distanceThreshold) {
        // floyd warshall algo

        vector<vector<int>> dists(n, vector<int>(n, 1000000));

        for (auto& edge : edges) {
            int c1 = edge[0];
            int c2 = edge[1];
            int wt = edge[2];
            dists[c1][c2] = wt;
            dists[c2][c1] = wt;
            dists[c1][c1] = 0;
            dists[c2][c2] = 0;
        }

        for (int via = 0; via < n; via++) {
            for (int from = 0; from < n; from++) {
                for (int to = 0; to < n; to++) {
                    dists[from][to] = min(dists[from][to], dists[from][via] + dists[via][to]);
                }
            }
        }

        vector<int> counts(n, 0);

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (dists[j][i] <= distanceThreshold) counts[j] += 1;
            }
        }

        int minIdx = 0;
        for (int i = 1; i < n; i++) {
            if (counts[i] <= counts[minIdx]) minIdx = i;
        }
        return minIdx;
    }
};