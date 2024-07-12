class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> case_list = new ArrayList<>();
        backtracking(nums, case_list, result);
        return result;
    }
    
    public void backtracking(int[] nums, List<Integer> case_list, List<List<Integer>> result){
        // System.out.println("case_list" + case_list);

        if(case_list.size() == nums.length){
            result.add(new ArrayList<>(case_list));
        }

        for(int num: nums){
            if(!case_list.contains(num)){
                case_list.add(num);
                backtracking(nums, case_list, result);
                case_list.remove(case_list.size()-1);
            }
        }
    }
}