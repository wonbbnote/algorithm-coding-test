class Solution {
    public int minCostClimbingStairs(int[] cost) {


        // nth 까지 가려면 n-1th까지 가고 1step OR n-2th까지 가고 2step

        // nth까지 가는데 최소비용
        int[] dp = new int[cost.length + 1];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int n = 2; n <= cost.length; n++){
            if(n == cost.length){
                dp[n] = Math.min(dp[n-1], dp[n-2]);
            }else{
                dp[n] = Math.min(dp[n-1] + cost[n], dp[n-2] + cost[n]);
            }
            
        }

        System.out.println(Arrays.toString(dp));

        return dp[cost.length];
    }
}