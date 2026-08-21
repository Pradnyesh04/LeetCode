import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency of each number
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets
        // Index = frequency
        List<Integer>[] buckets = new List[nums.length + 1];

        for (int num : freq.keySet()) {
            int count = freq.get(num);

            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }

            buckets[count].add(num);
        }

        // Step 3: Take elements from highest frequency to lowest
        int[] result = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {

            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[index++] = num;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}