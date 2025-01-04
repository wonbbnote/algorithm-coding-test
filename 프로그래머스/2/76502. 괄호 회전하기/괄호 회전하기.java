import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        
        int sLen = s.length();
        s += s;
        
        for(int i = 0; i < sLen; i++){
            ArrayDeque<Character> stack = new ArrayDeque<>();
            boolean right = true;
            
            for(int check = i; check < i + sLen; check++){
                char c = s.charAt(check);
                if(map.containsKey(c)){
                    stack.push(map.get(c));
                }else if(stack.isEmpty() || stack.pop() != c){
                    right = false;
                    break;
                }
            }
            
            if(right && stack.isEmpty()){
                answer++;
            }
            
        }
        
        
        return answer;
    }
}