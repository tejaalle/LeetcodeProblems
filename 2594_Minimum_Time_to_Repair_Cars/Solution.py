from typing import List
from math import sqrt


class Solution:
    def canRepair(self, x, ranks, cars):
        total = 0
        for rank in ranks:
            total += int(sqrt(x // rank))
            if total >= cars:
                return True
        return False

    def repairCars(self, ranks: List[int], cars: int) -> int:
        ranks = sorted(ranks)
        low = 1
        high = ranks[0] * cars * cars
        answer = high
        while (low <= high):
            mid = low + (high - low) // 2
            if self.canRepair(mid, ranks, cars):
                answer = mid
                high = mid - 1
            else:
                low = mid + 1
        return answer

