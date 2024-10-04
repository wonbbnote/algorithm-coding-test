import java.util.*;
class Solution {
    public int climbStairs(int n) {

        // climb(n) = climb(n-1) + climb(n-2);

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);


        for(int i = 1; i <= n; i++){
            if(i <= 2){
                dp[i] = i;
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
             
        }

        return dp[n];

        
    }


}