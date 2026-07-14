import java.util.*;

class Solution {

    static final int MOD = 1000000007;
    static final int MAX = 200;

    public int subsequencePairCount(int[] nums) {

        long[][] dp = new long[MAX + 1][MAX + 1];
        dp[0][0] = 1;

        for (int num : nums) {

            long[][] newDp = new long[MAX + 1][MAX + 1];

            for (int g1 = 0; g1 <= MAX; g1++) {

                for (int g2 = 0; g2 <= MAX; g2++) {

                    if (dp[g1][g2] == 0)
                        continue;

                    long ways = dp[g1][g2];

                    // Ignore current element
                    newDp[g1][g2] = (newDp[g1][g2] + ways) % MOD;

                    // Add to first subsequence
                    int gcd1 = (g1 == 0) ? num : gcd(g1, num);
                    newDp[gcd1][g2] = (newDp[gcd1][g2] + ways) % MOD;

                    // Add to second subsequence
                    int gcd2 = (g2 == 0) ? num : gcd(g2, num);
                    newDp[g1][gcd2] = (newDp[g1][gcd2] + ways) % MOD;
                }
            }

            dp = newDp;
        }

        long ans = 0;

        for (int g = 1; g <= MAX; g++) {
            ans = (ans + dp[g][g]) % MOD;
        }

        return (int) ans;
    }

    private int gcd(int a, int b) {

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}