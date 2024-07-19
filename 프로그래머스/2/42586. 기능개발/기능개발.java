import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> answer_list = new ArrayList<>();
        int return_num = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < progresses.length; i++){
            
            int day = (100 - progresses[i]) % speeds[i] == 0 ? (100-progresses[i]) / speeds[i] : (100-progresses[i]) / speeds[i] + 1;
            
            while(!stack.isEmpty() && stack.get(0) < day){
                stack.pop();
                return_num += 1;
            }
            if(i != 0 && stack.isEmpty()){
                answer_list.add(return_num);
                return_num = 0;
            }
            stack.push(day);
        }
        if(!stack.isEmpty()){
            answer_list.add(stack.size());
        }
        answer = answer_list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}