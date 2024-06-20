from typing import List
class Solution:
    def canPlaceBall(self, x, position, m):
        balls = 1
        curr_position = position[0]
        for i in range(1, len(position)):
            if position[i]-curr_position >=x:
                balls += 1
                curr_position = position[i]
            if balls == m:
                return True
        return False
    def maxDistance(self, position: List[int], m: int) -> int:
        position = sorted(position)
        low = 1
        high = int(position[-1]/(m-1))
        answer = 1
        while(low<=high):
            mid = low + (high-low)/2
            mid = int(mid)
            if self.canPlaceBall(mid, position, m):
                answer= mid
                low = mid+1
            else:
                high = mid-1
        return answer

