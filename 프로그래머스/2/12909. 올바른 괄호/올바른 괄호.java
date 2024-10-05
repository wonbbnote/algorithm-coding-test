import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] arr = s.toCharArray();
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(char c : arr){
            if(c == '('){
                stack.push('(');
            }else if(!stack.isEmpty()){
                stack.pop();
            }else{
                return false;
            }
        }
        if(!stack.isEmpty()){
            return false;
        }

        return answer;
    }
}