import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<int[]> resList = new ArrayList<>();
        
        // 가장 큰 수 찾기 위해 힙 & 큐에 {인덱스, 우선순위} 넣기 
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            pq.add(priorities[i]);
            queue.add(new int[] {i, priorities[i]});
        }
        
        while(!queue.isEmpty()){
            int[] popped = queue.remove();
            if(popped[1] == pq.peek()){
                resList.add(popped);
                pq.remove();
                
            }else{
                queue.add(popped);
            }
        }
        
        for(int i = 0; i < resList.size(); i++){
            if(resList.get(i)[0] == location){
                answer = i + 1;
                break;
            }
        }
        
        return answer;
    }
}