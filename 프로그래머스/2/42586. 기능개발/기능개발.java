import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++){
            int needDays = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            queue.add(needDays);
        }
        
        
        List<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()){
            int num = 1;
            int first = queue.poll();
            while(!queue.isEmpty() && queue.peek() <= first){
                queue.poll();
                num++;
            }
            answer.add(num);
        }
          
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}