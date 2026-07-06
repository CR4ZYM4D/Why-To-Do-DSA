class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // floyd warshall algo 

        int dists[][] = new int[n][n];
        for(int row[]: dists) Arrays.fill(row, 1_000_000);
        
        for(int[] edge: edges){
            int c1 = edge[0];
            int c2 = edge[1];
            int wt = edge[2];
            dists[c1][c2] = wt;
            dists[c2][c1] = wt;
            dists[c1][c1] = 0;
            dists[c2][c2] = 0;
        }

        for(int via = 0; via<n; via++){
            for(int from = 0; from<n; from++){
                for(int to = 0; to<n; to++){
                    dists[from][to] = Math.min(dists[from][to], dists[from][via] + dists[via][to]);
                }
            }
        }

        int[] counts = new int[n];

        for(int j=0; j<n; j++){
            for(int i=0; i<n; i++){
                if( dists[j][i] <= distanceThreshold) counts[j]+=1;
            }
        }

        int min = 0;
        for(int i=1; i<n; i++){
            if(counts[i] <= counts[min]) min = i;
        }
        return min;

    }   
}