import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> res = new ArrayList<>();
    
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i = 0; i < progresses.length; i++){
            int day = (100 - progresses[i]) / speeds[i];
            int remain = (100 - progresses[i]) % speeds[i];
            int needDay = remain == 0 ? day : day+1;
            queue.add(needDay);
        }
                
        while(!queue.isEmpty()){
            
            int firstNum = queue.peek();
            int num = 0;
            
            while(queue.size() > 0){
                if(queue.peek() <= firstNum){
                    queue.poll();
                    num++;
                }else{
                    break;
                }
            }

            res.add(num);
        }
        
        answer = res.stream().mapToInt(Integer::intValue).toArray();
        
        
        return answer;
    }
}