class Solution {

    public int[] topoSort(List<List<Integer>> adj, int[] indegree, int n){
        
        int count = 0;
        ArrayList<Integer> order = new ArrayList<Integer>();

        Queue<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            // add all source nodes to queue
            if(indegree[i] == 0){ dq.offer(i); count++; order.add(i);}
        }

        while(!dq.isEmpty()){
            int node = dq.poll();
            for(int v: adj.get(node)){
                indegree[v]--;
                if(indegree[v] == 0){dq.offer(v); count++; order.add(v);}

            }
        }
        if(count != n) return new int[]{};
        int res[] = new int[n];
        for(int i=0; i<n; i++) res[i] = order.get(i);
        return res;
    }

    public int[] findOrder(int n, int[][] pre) {
        // check if graph is cyclic or not using topo sort/ Kahn Algo 
        // need to build adjecency list yourself because fuck you
        
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];

        for(int i=0; i<n; i++) adj.add(new ArrayList<Integer>());

        for(int i[]: pre){
            // 1 directs to 0
            adj.get(i[1]).add(i[0]);
            indegree[i[0]]++;
        }
        return topoSort(adj, indegree, n);
    }
}