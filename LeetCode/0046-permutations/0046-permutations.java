import java.util.*;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalRes = new ArrayList<>();
        backtracking(nums, new ArrayList<>(), finalRes);
        return finalRes;

        
    }

    private void backtracking(int[] nums, List<Integer> ans, List<List<Integer>> finalRes){

        if(ans.size() == nums.length){
            finalRes.add(new ArrayList<>(ans));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!ans.contains(nums[i])){
                ans.add(nums[i]);
                backtracking(nums, ans, finalRes);
                ans.remove(ans.size() - 1);
            }
            
        }

    }
}