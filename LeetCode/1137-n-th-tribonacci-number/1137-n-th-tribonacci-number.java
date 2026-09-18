class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[n + 1];
        return cal(n, dp);
    }
    public int cal(int n, int[] dp){

        if(n <= 1){
            dp[n] = n;
        }else if(n == 2){
            dp[2] = 1;
        }else if(dp[n] == 0){
            dp[n] = cal(n-1, dp) + cal(n-2, dp) + cal(n-3, dp);
        }

        return dp[n];
    }
}