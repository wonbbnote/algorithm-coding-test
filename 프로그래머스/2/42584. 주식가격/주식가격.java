import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < prices.length; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int poppedIdx = stack.pop();
                answer[poppedIdx] = i - poppedIdx;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int poppedIdx = stack.pop();
            answer[poppedIdx] = prices.length - 1 - poppedIdx;
        }
        
        return answer;
    }
}