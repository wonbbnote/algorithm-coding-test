import java.util.*;
class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        my_string = my_string.replaceAll("[a-zA-Z]", " ");
        String[] list = my_string.split("\\s+");

        for(String s: list){
            if(!s.equals("")){
                answer += Integer.parseInt(s);   
            }
        }
        
        return answer;
    }
}