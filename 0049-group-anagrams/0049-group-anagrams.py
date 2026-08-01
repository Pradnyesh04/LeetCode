from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs):
        ans = defaultdict(list)

        for word in strs:
            freq = [0] * 26

            for ch in word:
                index = ord(ch) - ord('a')
                freq[index] += 1

            ans[tuple(freq)].append(word)

        return list(ans.values())