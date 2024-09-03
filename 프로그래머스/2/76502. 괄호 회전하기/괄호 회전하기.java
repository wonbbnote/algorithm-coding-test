import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
    
        for(int i = 0; i < s.length(); i++){
            String changed = s.substring(i);
            if(i > 0){
                changed += s.substring(0, i);
            }
            
            if(isRight(changed)){
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isRight(String s){
        char[] a = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for(char c : a){
            if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == '('){
                stack.push(')');
            }else{
                if(stack.isEmpty() || stack.pop() != c){
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}