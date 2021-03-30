from typing import List

from builtins import int


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        m = dict()
        index = 0
        for num in nums:
            idx = m.get(target - num)
            if idx is not None:
                return [idx, index]
            m[num] = index
            index += 1
        return None
