import java.util.*;

class Solution{
    
    static int answer;
    
    public int solution(String s){
        answer = 0;
        backtracking(s);
        return answer;
    }
    
    public void backtracking(String s){
        
        for(int i = s.length(); i >= 0; i--){ // 길이
            for(int j = 0; j <= s.length() - i; j++){ // start 인덱스
                // String str = s.substring(j, j + i);
                // System.out.println(str);
                if(isPalindrome(s, j, j + i - 1)){
                    answer = i;
                    return;
                }
            }
        }
    }
    
    public boolean isPalindrome(String str, int start, int end){
        // return s.equals((new StringBuilder(s)).reverse().toString());
        while(start <= end){
            if(str.charAt(start++) != str.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}