import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            // 회전한 string 만들기
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(i));
            if(i > 0){
                sb.append(s.substring(0, i));
            }
            // System.out.println(sb);
            
            // string 마다 돌면서 스택에 넣기 
            Stack<String> stack = new Stack<>();
            char[] charArr = sb.toString().toCharArray();
            
            boolean res = true;
            for(int j = 0; j < s.length(); j++){
                char c = charArr[j];
                if(c == '('){
                    stack.push(")");
                }else if(c == '{'){
                    stack.push("}");
                }else if(c== '['){
                    stack.push("]");
                }else{
                    if(stack.size() != 0){
                        String char_ = Character.toString(c);
                        String popped_char = stack.pop();
                        if(!char_.equals(popped_char)){
                            res = false;
                        }
                    }else{
                        res = false;
                    }
                }
            }
            if(stack.size() != 0){
                res = false;
            }
            if(res){
                answer++;
            }
            
        }
        
        
        return answer;
    }
}