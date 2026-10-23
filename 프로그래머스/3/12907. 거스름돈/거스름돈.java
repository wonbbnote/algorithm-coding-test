import java.util.*;
class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for(int coin: money){
            for(int x = coin; x <= n; x++){
                dp[x] = (dp[x] + dp[x-coin]) % 1_000_000_007;
            }
            
        }
        return dp[n];
    }
}