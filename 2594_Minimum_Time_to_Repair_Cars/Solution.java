import java.util.*;
class Solution {
    public boolean canRepair(long x, int[] ranks, int cars){
        int total = 0;
        for(int rank: ranks){
            total += Math.sqrt(x/rank);
            if(total>=cars){
                return true;
            }
        }
        return false;
    }
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        long low = 1;
        long high = (long) ranks[0]*cars*cars;
        long answer = high;
        while(low<=high){
            long mid = low+ (high-low)/2;
            if(canRepair(mid, ranks, cars)){
                answer = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return answer;

    }
}