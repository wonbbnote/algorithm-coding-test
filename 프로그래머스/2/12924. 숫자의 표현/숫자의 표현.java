import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        List<List<Integer>> finalRes = new ArrayList<>();
        
        for(int i = 1; i <= n; i++){
            backtracking(i, n, 0, new ArrayList<>(), finalRes);
        }
        // System.out.println(finalRes);
        
        return finalRes.size();
    }
    
    private void backtracking(int i, int n, int sum, List<Integer> arr, List<List<Integer>> finalRes){
        
        // System.out.println(i + ": " + arr + " => " + sum);

        
        if(sum == n){
            finalRes.add(new ArrayList<>(arr));
            return;
        }
        
        if(sum < n){
            arr.add(i);
            backtracking(i+1, n, sum+i, arr, finalRes);
        }
        
    }
}