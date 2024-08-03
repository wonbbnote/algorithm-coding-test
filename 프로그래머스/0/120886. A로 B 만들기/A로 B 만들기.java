import java.util.*;
class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        
        Map<String, Integer> beforeMap = new HashMap<>();
        
        for(int i = 0; i < before.length(); i++){
            String oneStr = before.substring(i, i+1);
            if(!beforeMap.containsKey(oneStr)){
                beforeMap.put(oneStr, 1);
            }else{
                beforeMap.put(oneStr, beforeMap.get(oneStr) + 1);
            }
        }
        
        Map<String, Integer> afterMap = new HashMap<>();
        
        for(int i = 0; i < after.length(); i++){
            String oneStr = after.substring(i, i+1);
            if(!afterMap.containsKey(oneStr)){
                afterMap.put(oneStr, 1);
            }else{
                afterMap.put(oneStr, afterMap.get(oneStr) + 1);
            }
        }

        if(beforeMap.equals(afterMap)){
            answer = 1;
        }
                    
        return answer;
    }
}