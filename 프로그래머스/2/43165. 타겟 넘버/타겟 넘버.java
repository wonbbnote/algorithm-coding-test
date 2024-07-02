import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        List<Integer> case_list = new ArrayList<>();
        List<Integer> answer_list = new ArrayList<>();
        backtracking(numbers, 0, case_list, answer_list, target);
        // System.out.println(answer_list);
        answer = answer_list.size();
        return answer;
    }
    
    public void backtracking(int[] numbers, int cur, List<Integer> case_list, List<Integer> answer_list, int target){
        
        if(case_list.size() == numbers.length){
            int sum_val = case_list.stream().mapToInt(Integer::intValue).sum();
            if(sum_val == target){
                answer_list.add(sum_val);
            }
            return;
        }
        
        int[] two_cases = new int[] {numbers[cur], -numbers[cur]};
        for(int a_case: two_cases){
            case_list.add(a_case);
            if(case_list.size() <= numbers.length){
                backtracking(numbers, cur+1, case_list, answer_list, target);
            }
            case_list.remove(case_list.size()-1);
        }
        
        
    }
}