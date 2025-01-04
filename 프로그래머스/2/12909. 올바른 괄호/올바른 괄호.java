import java.util.*;
class Solution {
    boolean solution(String s) {
        
        char[] sArr = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(char c: sArr){
            if(c == '('){
                stack.push(c);
            }else if(!stack.isEmpty()){
                stack.pop();
            }else{
                return false;
            }
        }
        
        if(!stack.isEmpty()){
            return false;
        }
        
        return true;
        
    }
}