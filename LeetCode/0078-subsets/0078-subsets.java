class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> case_list = new ArrayList<>();
        backtracking(0, nums, case_list, result);
        return result;
        
    }

    public void backtracking(int start, int[] nums, List<Integer> case_list, List<List<Integer>> result){
        result.add(new ArrayList<>(case_list));
        
        for(int i = start; i < nums.length; i++){
            case_list.add(nums[i]);
            backtracking(i+1, nums, case_list, result);
            case_list.remove(case_list.size()-1);
        }

    }
}