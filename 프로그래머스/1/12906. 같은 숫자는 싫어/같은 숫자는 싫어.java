import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for(int a: arr){
            if(!stack.isEmpty()){
                if(stack.peek() == a){
                    continue;
                }
            }
            stack.push(a);
        }
        
        int num = stack.size();
        int[] answer = new int[num];
        for(int i = num-1; i >= 0; i--){
            answer[i] = stack.pop();
        }

        return answer;
    }
}