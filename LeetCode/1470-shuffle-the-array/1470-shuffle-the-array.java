class Solution {
    public int[] shuffle(int[] nums, int n) {

        int[] ans = new int[nums.length];

        for(int i = 0; i < n * 2; i++){
            int nth = i / 2;
            if(i % 2 == 0){
                ans[i] = nums[nth];
            }else{
                ans[i] = nums[nth + n];
            }
        }

        return ans;
        
    }
}