import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<int[]> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1] > prices[i]) {
                int[] popped = stack.pop();
                answer[popped[0]] = i - popped[0];
            }
            stack.push(new int[] {i, prices[i]});
        }
        
        while (!stack.isEmpty()) {
            int[] popped = stack.pop();
            answer[popped[0]] = prices.length - popped[0] - 1;
        }
        
        return answer;
    }
}
