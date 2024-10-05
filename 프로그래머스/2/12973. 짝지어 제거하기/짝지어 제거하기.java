import java.util.*;
class Solution
{
    public int solution(String s)
    {
        char[] sArr = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0; i < sArr.length;i++){
            if(!stack.isEmpty() && stack.peek() == sArr[i]){
                stack.pop();
            }else{
                stack.push(sArr[i]);
            }
        }
        
        if(stack.isEmpty()){
            return 1;
        }

        return 0;
    }
}