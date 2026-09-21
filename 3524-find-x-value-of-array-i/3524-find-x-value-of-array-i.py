class Solution:
    def resultArray(self, nums, k):
        ans = [0] * k
        dp = [0] * k

        for num in nums:
            num %= k
            new = [0] * k

            new[num] += 1

            for r in range(k):
                new[(r * num) % k] += dp[r]

            dp = new

            for r in range(k):
                ans[r] += dp[r]

        return ans