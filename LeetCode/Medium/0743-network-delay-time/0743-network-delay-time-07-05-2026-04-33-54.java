class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        
        for(int i=0; i<=n ;i++){
            adj.add(new ArrayList<int[]>());
        }
        for(int arr[]: times){
            adj.get(arr[0]).add(new int[]{arr[2], arr[1]});
        }

        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{return a[1]-b[1];});
        pq.offer(new int[]{k, 0});
        while(!pq.isEmpty()){
            int arr[] = pq.poll();
            int node = arr[0];
            int cost = arr[1];
            for(int[] i: adj.get(node)){
                int newCost = cost + i[0];
                int neigh = i[1];
                if(newCost < dist[neigh]){ dist[neigh] = newCost;
                pq.offer(new int[]{neigh, newCost});} 
            }
        }
        int minTime = 0;
        for(int i=1; i<=n; i++)
        minTime = Math.max(minTime, dist[i]);
        return minTime == Integer.MAX_VALUE? -1: minTime;
    }
}