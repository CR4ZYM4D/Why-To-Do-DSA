class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    
        int stops[] = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
     
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<int[]>());
        }

        for(int arr[]: flights){
            adj.get(arr[0]).add(new int[]{arr[2], arr[1]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->{return a[0] - b[0];});
        
        stops[src] = 0;
        pq.offer(new int[]{0, src, 0});
        while(!pq.isEmpty()){
            
            int[] arr = pq.poll();           
            int dist = arr[0];
            int city = arr[1];
            int s = arr[2];

            if(city == dst)  return dist;
            if(s>k || stops[city] < s) continue;
            stops[city] = s;

            for(int[] neigh: adj.get(city)){
                int c1 = neigh[1];
                int d = neigh[0];
                int newDist = d + dist;

                pq.offer(new int[]{newDist, c1, s+1});

            }
        }
        return -1;
    }
}