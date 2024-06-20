import java.util.*;
class Solution {
    public boolean canPlaceBall(int x, int[] position, int m){
        int ball_placed = 1;
        int last_position = position[0];
        for (int i=1; i<position.length;i++){
            if((position[i]- last_position) >=x){
                ball_placed += 1;
                last_position = position[i];
            }
            if(ball_placed == m){
                return true;
            }
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int high = position[position.length -1]/(m-1);
        int answer = 1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if (canPlaceBall(mid, position, m)){
                answer = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }

        }
        return answer;

    }
}