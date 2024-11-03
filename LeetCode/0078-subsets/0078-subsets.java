import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> finalRes = new ArrayList<>();
        backtracking(0, nums, new ArrayList<>(), finalRes);
        return finalRes;
        
    }

    private void backtracking(int start, int[] nums, List<Integer> ans, List<List<Integer>> finalRes){
        finalRes.add(new ArrayList<>(ans));

        for(int i = start; i < nums.length; i++){
            ans.add(nums[i]);
            backtracking(i+1, nums, ans, finalRes);
            ans.remove(ans.size() - 1);
        }
    }
}