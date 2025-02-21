import java.util.*;
class Solution {
    boolean solution(String s) {
        
        char[] sArr = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        
        for(char c: sArr){
            if(c == '('){
                stack.push(c);
            }else if(!stack.isEmpty() && c == ')'){
                stack.pop();
            }else{
                return false;
            }
        }

        return stack.isEmpty();
    }
}