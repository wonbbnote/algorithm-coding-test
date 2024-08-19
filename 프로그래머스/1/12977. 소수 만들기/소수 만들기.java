import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int finalAnswer = 0;

        List<List<Integer>> answer = new ArrayList<>();
        backtracking(0, nums.length, new ArrayList<>(), answer);
        
        for(int i = 0; i < answer.size(); i++){
            int value = nums[answer.get(i).get(0)] + nums[answer.get(i).get(1)] + nums[answer.get(i).get(2)];
            if(isPrime(value)){
                finalAnswer++;
            }
        }

        return finalAnswer;
    }
    
    public void backtracking(int start, int num, List<Integer> cas, List<List<Integer>> answer){
        
        if(cas.size() == 3){
            answer.add(new ArrayList<>(cas));
            return;
        }
        
        for(int i = start; i < num; i++){
            cas.add(i);
            backtracking(i+1, num, cas, answer);
            cas.remove(cas.size()-1);
        }
        
    }
    
    public boolean isPrime(int num){
        for(int i = 2; i <= num/2; i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }
        
}