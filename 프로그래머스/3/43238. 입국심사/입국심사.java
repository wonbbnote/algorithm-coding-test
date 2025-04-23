import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        long left = 0;
        long right = times[times.length - 1] * (long) n;
        
        while(left <= right){
            long mid = ( left + right ) / 2; // n명을 심사하는 데 걸리는 총시간
            
            long possibleN = 0;
            for(int time: times){
                long cnt = mid / time;
                possibleN += cnt;
            }
            
            if(possibleN < n){
                left = mid + 1; 
            }else{
                right = mid - 1;
                answer = mid;
            }
            
        }
        
        
        return answer;
    }
}