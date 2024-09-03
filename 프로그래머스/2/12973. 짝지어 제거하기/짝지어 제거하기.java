import java.util.*;
class Solution{
    public int solution(String s){
        
        char[] sArr = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        stack.push(sArr[0]);
        
        for(int i = 1; i < sArr.length; i++){
            if(!stack.isEmpty() && stack.peek() == sArr[i]){
                stack.pop();
            }else{
                stack.push(sArr[i]);
            }
        }
        
        int answer = stack.isEmpty() ? 1 : 0;

        return answer;
    }
}