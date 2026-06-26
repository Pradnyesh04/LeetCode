import java.util.*;

class Solution {

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        // Prefix sum array
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                prefix[i + 1] = prefix[i] + 1;
            } else {
                prefix[i + 1] = prefix[i] - 1;
            }
        }

        // Coordinate Compression
        int[] sorted = prefix.clone();
        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 1;

        for (int x : sorted) {
            if (!map.containsKey(x)) {
                map.put(x, idx++);
            }
        }

        Fenwick bit = new Fenwick(idx + 2);

        long ans = 0;

        for (int p : prefix) {
            int rank = map.get(p);

            // Count previous prefix sums smaller than current
            ans += bit.query(rank - 1);

            bit.update(rank, 1);
        }

        return ans;
    }

    static class Fenwick {
        int[] tree;

        Fenwick(int n) {
            tree = new int[n + 2];
        }

        void update(int i, int val) {
            while (i < tree.length) {
                tree[i] += val;
                i += i & -i;
            }
        }

        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }
    }
}