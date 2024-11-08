import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        // n = 20;
        int[] answer = new int[n];
        
        
        // k를 (n-1)!으로 나눈 몫
        long[] dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 2;
        factorial(n, dp);
        // System.out.println(Arrays.toString(dp));
        
        List<Integer> people= new ArrayList<>();
        for(int i = 1; i <= n; i++){
            people.add(i);
        }
        
        int num = 1;
        for(int i = 0; i < n-1; i++){
            
            long val = k / dp[n - num];
            // System.out.println("dp[n - num]: "+ dp[n - num]);
            if(k % dp[n - num] == 0){
                val -= 1;
                k = dp[n - num];
            }else{
                k = k % dp[n - num];
            }
            num++;
            
            int res = people.get((int) val);
            people.remove((int) val);
        
            answer[i] = res;
        }
        
        answer[n - 1] = people.get(0);
        
        return answer;
    }
    
    private long factorial(int n, long[] dp){
        if(dp[n] == 0){
            dp[n] = factorial(n-1, dp) * n;
        }
        return dp[n];
    }
}