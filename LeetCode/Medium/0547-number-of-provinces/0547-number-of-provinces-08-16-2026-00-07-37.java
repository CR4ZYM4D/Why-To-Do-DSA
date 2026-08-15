class Solution {

    public void union(int[] parent, int u, int v){
    
        int p1 = find(parent, u);
        int p2 = find(parent, v);

        if(p1 == p2)
            return;

        parent[p1] = p2;
        return;
    }

    public int findCircleNum(int[][] is) {

        int n = is.length;
        int parents[] = new int[is.length];
        for(int i=0; i<parents.length; i++) parents[i] = i;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(is[i][j] == 1) union(parents, i, j);
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i: parents) set.add(find(parents, i));
        return set.size();

    }

    public int find(int[] parent, int node){
        if(parent[node] == node) return node;
        return find(parent, parent[node]);
    }
}