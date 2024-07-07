class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length+1];
        Arrays.fill(memo, -1);
        return maxMoney(nums, nums.length, memo);
    }

    public int maxMoney(int[] money_lst, int n, int[] memo){

        if(memo[n] == -1){
            
            if(n == 0){
                memo[0] = 0;
            }else if(n == 1){
                memo[1] = money_lst[0];
            }else{
                int case_1 = maxMoney(money_lst, n-2, memo) + money_lst[n-1];
                int case_2 = maxMoney(money_lst, n-1, memo);
                memo[n] = case_1 >= case_2 ? case_1 : case_2;
            }
        }
        
        return memo[n];

    }
}