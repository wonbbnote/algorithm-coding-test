import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        String sNew = s + s;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++){
            String sub = sNew.substring(i, i+s.length());
            char[] subArr = sub.toCharArray();
            boolean right = true;
            for(char c: subArr){
                if(map.containsKey(c)){
                    stack.push(map.get(c));
                }else{
                    if(stack.isEmpty() || stack.pop() != c){
                        right = false;
                        break;
                    }
                }
            }
            if(right && stack.isEmpty()){
                answer++;
            }
        }
        
        
        return answer;
    }
}