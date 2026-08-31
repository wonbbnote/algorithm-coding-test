import java.util.*;
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int max = 0;

        int[] ans = new int[nums.length];
        if(nums[0] == 1){
            ans[0] = 1;
            max = 1;
        }
        
        for(int i = 1; i < nums.length; i++){

            if(nums[i] == 0){
                ans[i] = 0;
            }else{
                ans[i] = ans[i-1] + 1;
            }

            max = Math.max(max, ans[i]);

        }    

        return max;    

    }
}