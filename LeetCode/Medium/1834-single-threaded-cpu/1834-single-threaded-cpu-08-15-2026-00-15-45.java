class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] indexed = new int[n][3];
        for (int i = 0; i < n; i++)
            indexed[i] = new int[]{tasks[i][0], tasks[i][1], i};
        Arrays.sort(indexed, (a, b) -> a[0] - b[0]); 

        PriorityQueue<int[]> available = new PriorityQueue<>((a, b) ->
            a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int[] res = new int[n];
        int idx = 0, i = 0;
        long currentTime = 0;

        while (idx < n) {

            while (i < n && indexed[i][0] <= currentTime) {
                available.offer(new int[]{indexed[i][1], indexed[i][2]});
                i+=1;
            }
            if (i<n && available.isEmpty()) {
                currentTime = indexed[i][0];
                continue;
            }
            int[] task = available.poll();
            res[idx++] = task[1];
            currentTime += task[0];
        }
        return res;
    }
}