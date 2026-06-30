class Solution {

    public boolean dfs(int node, int color, int[] colors, int[][] adj){
        int n = adj[node].length;
        colors[node] = color;
        for(int i=0; i<n; i++){
            if(colors[adj[node][i]] == -1){
                if(!dfs(adj[node][i], color^1, colors, adj)) return false;
            }
            else if(colors[adj[node][i]] == color) return false;
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        
        // use dfs to color all uncolored neighbor nodes as 0 or 1
        // if a neighbor node is already colored check that it has 
        // the opposite color as current node
        // loops complete graph is bipartite
        int n = graph.length;
        int color[] = new int[n];

        Arrays.fill(color, -1);

        for(int i=0; i<n; i++){
            if(color[i] == -1){
                if(!dfs(i, 0 , color, graph)) return false;
            }
        } 

        return true;
    }
}