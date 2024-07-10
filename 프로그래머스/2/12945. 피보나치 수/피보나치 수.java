import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i = 2; i < n+1; i++){
            if(dp[i] == -1){
                dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
            }
            // System.out.println(Arrays.toString(dp));
        }
        
        // answer = dp[n] % 1234567;
        answer = dp[n];
        
        return answer;
    }
}