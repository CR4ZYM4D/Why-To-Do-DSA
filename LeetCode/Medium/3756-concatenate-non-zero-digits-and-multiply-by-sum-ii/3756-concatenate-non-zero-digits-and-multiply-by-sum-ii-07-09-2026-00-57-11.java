class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        long MOD = 1_000_000_007L;

        long[] pow10 = new long[n + 1];
        int[] nz = new int[n + 1];
        long[] xPre = new long[n + 1];
        long[] sumPre = new long[n + 1];

        pow10[0] = 1L;
        for (int i = 1; i <= n; i++) pow10[i] = (pow10[i - 1] * 10) % MOD;

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - '0';
            nz[i + 1] = nz[i];
            xPre[i + 1] = xPre[i];
            sumPre[i + 1] = sumPre[i];
            if (c > 0) {
                nz[i + 1] = nz[i] + 1;
                xPre[i + 1] = (xPre[i] * 10 + c) % MOD;
                sumPre[i + 1] = sumPre[i] + c;
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];

            int k = nz[r + 1] - nz[l];
            long x = ((xPre[r + 1] - xPre[l] * pow10[k]) % MOD + MOD) % MOD;
            long sod = (sumPre[r + 1] - sumPre[l]) % MOD;

            res[i] = (int) ((x * sod) % MOD);
        }
        return res;
    }
}