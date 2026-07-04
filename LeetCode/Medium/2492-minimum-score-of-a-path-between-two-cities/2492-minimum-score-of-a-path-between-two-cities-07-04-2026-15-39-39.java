class Solution {
    public int minScore(int n, int[][] roads) {
        boolean[] visited = new boolean[n+1];
        
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++)
            adj.add(new ArrayList<int[]>());
        for(int[] arr: roads){
            int c1 = arr[0];
            int c2 = arr[1];
            int d = arr[2];
            adj.get(c1).add(new int[]{c2, d});
            adj.get(c2).add(new int[]{c1, d});
        }

        Queue<Integer> dq = new ArrayDeque<>();
        dq.offer(1);
        int minDist = (int)(1e6);
        while(!dq.isEmpty()){
            int city = dq.poll();
            if(!visited[city]){
                visited[city] = true;
                for(int[] arr: adj.get(city)){
                    int c2 = arr[0];
                    int dist = arr[1];
                    if(dist<minDist) minDist = dist;
                    if(!visited[c2]) dq.offer(c2);
                }
            } 
        }

        return minDist;
    }
}