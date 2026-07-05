class Solution {
    public int countPaths(int n, int[][] roads) {
        final int modulo = 1_000_000_007;
        List<long[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] arr : roads) {
            int c1 = arr[0], c2 = arr[1], dist = arr[2];
            adj[c1].add(new long[]{c2, dist});
            adj[c2].add(new long[]{c1, dist});
        }

        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE); 
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] arr = pq.poll();
            int city = (int) arr[0];
            long cost = arr[1];
            if (cost > dist[city]) continue;

            for (long[] e : adj[city]) {
                int neigh = (int) e[0];
                long wt = e[1];
                long newDist = wt + cost; 
                if (newDist < dist[neigh]) {
                    dist[neigh] = newDist;
                    ways[neigh] = ways[city];
                    pq.offer(new long[]{neigh, newDist});
                } else if (newDist == dist[neigh]) {
                    ways[neigh] = (ways[neigh] + ways[city]) % modulo;
                }
            }
        }
        return (int) (ways[n - 1] % modulo);
    }
}