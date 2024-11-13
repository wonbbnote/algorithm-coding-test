import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char[] arr = s.toCharArray();

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for(char c: arr){
            if(map.containsKey(c)){
                stack.push(map.get(c));
            }else if(!stack.isEmpty() && stack.peek() == c){
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