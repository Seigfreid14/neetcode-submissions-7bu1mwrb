from collections import defaultdict

class Solution:
    def topKFrequent(self, nums: list[int], k: int) -> list[int]:
        d = defaultdict(int)
        res = []

        # count frequency
        for num in nums:
            d[num] += 1

        # get top k elements
        for i in range(k):
            max_key = max(d, key=d.get)
            res.append(max_key)
            d.pop(max_key)

        return res