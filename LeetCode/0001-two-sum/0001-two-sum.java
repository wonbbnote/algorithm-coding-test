import java.util.*;
class Solution {

    public int[] twoSum(int[] nums, int target) {
        return backtracking(0, nums, target, new ArrayList<>());
    }

    private int[] backtracking(int start, int[] nums, int target, List<Integer> ans){

        if(ans.size() == 2){
            if(nums[ans.get(0)] + nums[ans.get(1)] == target){
                return new int[] {ans.get(0), ans.get(1)};
            }
            return null;
        }
        

        for(int i = start; i < nums.length; i++){
            ans.add(i);
            int[] result = backtracking(i + 1, nums, target, ans);
            if(result == null){
                ans.remove(ans.size()-1);
            }else{
                return result;
            }
        }

        return null;

    }
}