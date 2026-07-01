class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // build reverse directed graph to make safe nodes as top priority/level 
        // use topo sort to detect and build dag
        // all its nodes reach end state, sort them
        ArrayList<Integer> res = new ArrayList<>();
        int n = graph.length;
        int inDegree[] = new int[n];
        Queue<Integer> dq = new ArrayDeque<>();
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            for(int j: graph[i]){
                adj.get(j).add(i);
                inDegree[i]++;
            }
        }
        for(int i=0; i<n; i++){
            if(inDegree[i] == 0) dq.offer(i);
        }

        while(!dq.isEmpty()){
            int node = dq.poll();
            res.add(node);
            for(int i: adj.get(node)){
                inDegree[i]--;
                if(inDegree[i] == 0) dq.offer(i);
            }
        }
        Collections.sort(res);
        return res;
    }
}