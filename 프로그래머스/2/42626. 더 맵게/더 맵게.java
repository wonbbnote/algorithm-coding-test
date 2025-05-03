import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s: scoville){
            pq.add(s);
        }
        
        boolean possible = false;
        while(!pq.isEmpty()){
            int first = pq.poll();
            if(first >= K){
                possible = true;
                break;
            }else if(!pq.isEmpty()){
                int sec = pq.poll();
                int newS = first + (sec * 2);
                pq.add(newS);
                answer++;
            }
        }
        
        
        if(!possible){
            return -1;
        }
        
        return answer;
    }
}