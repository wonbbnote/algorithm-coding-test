import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < enroll.length; i++){
            map.put(enroll[i], i);
        }
        
        for(int i = 0; i < seller.length; i++){
            dfs(map.get(seller[i]), (double) amount[i] * 100, map, referral, answer);
        }

        return answer;
    }
    
    private void dfs(int idx, double money, Map<String, Integer> map, String[] referral, int[] answer){
        
        
        if(money >= 10){
            double bene = Math.ceil(money * 0.9);
            answer[idx] += bene;
            if(!referral[idx].equals("-")){
                dfs(map.get(referral[idx]), money - bene, map, referral, answer);
            }
            
        }else{
            answer[idx] += money;
        }
        
        
    }
}