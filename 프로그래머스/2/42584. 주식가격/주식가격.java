import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < prices.length; i++){
            while(!stack.isEmpty() && prices[stack.peek()]  > prices[i]){
                int popped = stack.pop();
                answer[popped] = i - popped;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int popped = stack.pop();
            answer[popped] = prices.length - 1 - popped;
        }
        return answer;
    }
}