import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        for(String person: participant){
            if(!map.containsKey(person)){
                map.put(person, 1);
            }else{
                map.put(person, map.get(person)+1);
            }
        }
        
        for(String person: completion){
            map.put(person, map.get(person)-1);
        }
        
        for(String key: map.keySet()){
            if(map.get(key) != 0){
                answer = key;
                break;
            }
        }
        
        
        return answer;
    }
}