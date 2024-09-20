import java.util.*;
class Solution {
    
    public int solution(String numbers) {
        int answer = 0;

        List<Integer> caseList = new ArrayList<>();
        Set<Integer> res = new HashSet<>();
        backtracking(numbers, caseList, answer, res);
        
        return res.size();
    }
    
    public void backtracking(String numbers, List<Integer> caseList, int answer, Set<Integer> res){
        
        // System.out.println("caseList: " +caseList);
        
        if(caseList.size() > 0){
            String casestr = "";
            for(int i = 0; i < caseList.size(); i++){
                casestr += numbers.charAt(caseList.get(i));
            }
            // System.out.println("casestr: " +casestr);
            
            if(isPrime(Integer.valueOf(casestr))){
                res.add(Integer.valueOf(casestr));
            }
        }
        
        for(int i = 0; i < numbers.length(); i++){
            if(!caseList.contains(i)){
                caseList.add(i);
                backtracking(numbers, caseList, answer, res);
                caseList.remove(caseList.size()-1);
            }   
        }
    }
    
    public boolean isPrime(int num){
        if(num == 0 || num == 1){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}