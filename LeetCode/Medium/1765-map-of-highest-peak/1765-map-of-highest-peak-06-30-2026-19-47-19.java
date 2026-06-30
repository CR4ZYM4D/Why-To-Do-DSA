class Solution {
    public int[][] highestPeak(int[][] mat) {
          // use BFS to search nearest zeros
        int coords[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int n = mat[0].length;
        int m = mat.length;
        int[][] dist = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> dq = new ArrayDeque<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1){ dq.offer(new int[]{i, j}); dist[i][j] = 0; visited[i][j] = true;}
            }
        }

        int steps = 1;
        while(!dq.isEmpty()){
            int l = dq.size();
            while(l-->0){
                int[] arr = dq.poll();
                for(int i[]: coords){
                    int r = arr[0] + i[0];
                    int c = arr[1] + i[1];
                    if(r<0 || c<0 || r>=m || c>=n || visited[r][c]) continue;
                    visited[r][c] = true;
                    dist[r][c] = steps;
                    dq.offer(new int[]{r, c});
                }
            }
            steps++;
        }
       
        return dist;
    }
}