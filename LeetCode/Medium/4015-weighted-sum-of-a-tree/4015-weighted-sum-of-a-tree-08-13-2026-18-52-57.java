class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) children.add(new ArrayList<>());
        for (int i = 1; i < n; i++) children.get(parent[i]).add(i);

        int[] depth = new int[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        depth[0] = 1;
        int maxHeight = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            maxHeight = Math.max(maxHeight, depth[node]);
            for (int child : children.get(node)) {
                depth[child] = depth[node] + 1;
                queue.offer(child);
            }
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) nums[i] * (maxHeight - depth[i] + 1);
        }
        return sum;
    }
}