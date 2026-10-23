class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        int[] gop = new int[]{1, -1};
        // n번째를 마지막으로 하는 연속 펄스 부분 수열의 최댓값
        // 1, -1을 곱했을 때의 최댓값
        long[][] dp = new long[sequence.length][2]; 
        dp[0][0] = sequence[0] * 1;
        dp[0][1] = sequence[0] * -1;
        answer = Math.max(dp[0][0], dp[0][1]);
        
        
        for(int n = 1; n < sequence.length; n++){
            
            dp[n][0] = Math.max(dp[n-1][1] + sequence[n] * gop[0], sequence[n] * gop[0]);
            dp[n][1] = Math.max(dp[n-1][0] + sequence[n] * gop[1], sequence[n] * gop[1]);
            
            answer = Math.max(answer, dp[n][0]);
            answer = Math.max(answer, dp[n][1]);
        }
        

        return answer;
    }
}