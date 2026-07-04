class Solution {
    public int minimumEffortPath(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<int[]> dq = new PriorityQueue<int[]>((a,b) -> {return a[0] - b[0];});
        int[][] visited = new int[m][n];
        for(int row[]: visited)Arrays.fill(row, Integer.MAX_VALUE);
        
        int[][] coords = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        dq.offer(new int[]{0, 0, 0});
        visited[0][0] = 0;
        int maxEffort = 0;
        while(!dq.isEmpty()){
            int[] arr = dq.poll();
            int dist = arr[0];
            int r = arr[1];
            int c = arr[2];

            if(r == m-1 && c == n-1) return dist;

            for(int i[]: coords){
                int r1 = r + i[0];
                int c1 = c + i[1];
                if(r1<0 || c1<0 || r1>=m || c1>=n) continue;
                int newDist = Math.abs(grid[r1][c1] - grid[r][c]);
                newDist = Math.max(newDist, dist);
                if(newDist< visited[r1][c1]){
                    visited[r1][c1] = newDist;
                    dq.offer(new int[]{newDist, r1, c1});
                }
            }
        }
        return 0;
    }
}