import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            if(!map.containsKey(array[i])){
                map.put(array[i], 1);
            }else{
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        // System.out.println(map);
        Integer maxValue = Collections.max(map.values());
        // System.out.println(maxValue);
        
        int num = 0;
        int result = 0;
        for(Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() == maxValue){
                result = entry.getKey();
                num += 1;
            }
            if(num > 1){
                result = -1;
                break;
            }
        }
        answer = result;
    
        return answer;
    }
}