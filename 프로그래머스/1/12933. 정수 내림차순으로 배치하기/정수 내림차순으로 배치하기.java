import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;

        String[] nStr = String.valueOf(n).split("");
        
        Arrays.sort(nStr, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(String digit: nStr){
            sb.append(digit);
        }
        
        return Long.parseLong(sb.toString());
    }
}