class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int[][] visited = new int[n][n];
        for(int[] row: visited) Arrays.fill(row, Integer.MAX_VALUE);
        Queue<int[]> dq = new ArrayDeque<>();
        int[][] coords = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        visited[0][0] = 1;
        if(grid[0][0] == 0)
        dq.offer(new int[] {0, 0});
        while(!dq.isEmpty()){
            int[] arr = dq.poll();
            int r = arr[0];
            int c = arr[1];
            if(r==n-1 && c==n-1) return visited[r][c];
            for(int coord[]: coords){
                int r1 = r + coord[0];
                int c1 = c + coord[1];
                if(r1<0 || c1<0 || r1>=n || c1>=n || visited[r1][c1] != Integer.MAX_VALUE || grid[r1][c1]==1)
                    continue;
                visited[r1][c1] = visited[r][c]+1;
                dq.offer(new int[]{r1, c1});
            }
        }
        return -1;
    }
}