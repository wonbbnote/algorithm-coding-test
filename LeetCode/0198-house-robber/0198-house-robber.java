class Solution {
    public int rob(int[] nums) {
        int max = 0;
        // n번째 집을 털때 갔을 때 최대 털 수 있는 돈
        // n-2번째를 털고, n번째를 턴다. OR n-1번째 까지 턴다. n번째는 털지 않는다.
        //dp[2] = Math.max(dp[1], dp[0] + nums[2]);
        
        if(nums.length <= 1){
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        max = Math.max(dp[0], dp[1]);

        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;

        
    }
}