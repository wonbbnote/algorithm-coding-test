import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>(scoville.length);
        for (int num : scoville) {
            list.add(num);
        }
        Queue<Integer> pq = new PriorityQueue<>(list);
        // Integer lowest = pq.remove();
        
//         while(lowest < K){

//             if(pq.size() == 1){
//                 return -1;
//             }
            
//             Integer sec = pq.remove();
//             Integer newFood = lowest + sec * 2;
//             pq.add(newFood);
//             answer++;
            
//             // System.out.println("pq: "+ pq);
            
//             lowest = pq.remove();
            
//         }
        
        
        while(pq.size() > 1){
            Integer lowest = pq.remove();
            if(lowest >= K){
                return answer;
            }
            Integer second = pq.remove();
            Integer newFood = lowest + second * 2;
            pq.add(newFood);
            answer++;
        }
        
        Integer remainOne = pq.remove();
        if(remainOne >= K){
            return answer;
        }
        
        return -1;
    }
}