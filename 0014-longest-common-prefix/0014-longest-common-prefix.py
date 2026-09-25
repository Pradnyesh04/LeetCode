class Solution:
    def longestCommonPrefix(self, strs):
        ans = strs[0]

        for s in strs:
            i = 0

            while i < len(ans) and i < len(s) and ans[i] == s[i]:
                i += 1

            ans = ans[:i]

            if ans == "":
                return ""

        return ans