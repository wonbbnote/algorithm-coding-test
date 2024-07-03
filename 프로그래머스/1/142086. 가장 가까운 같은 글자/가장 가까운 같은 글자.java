import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        Map<String, Integer> hashmap = new HashMap<>();
        String[] s_arr = s.split("");
        int[] answer = new int[s_arr.length];
        
        for(int i = 0; i < s_arr.length; i++){
            if(!hashmap.containsKey(s_arr[i])){
                answer[i] = -1;
            }else{
                answer[i] = i - hashmap.get(s_arr[i]);
            }
            hashmap.put(s_arr[i], i);
        }
        
        return answer;
    }
}