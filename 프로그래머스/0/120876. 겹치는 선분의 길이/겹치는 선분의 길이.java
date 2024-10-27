import java.util.*;
class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i < lines.length; i++){
            for(int j = lines[i][0]; j < lines[i][1]; j++){
                if(!map.containsKey(j)){
                    map.put(j, false);
                }else{
                    if(!map.get(j)){
                        map.put(j, true);
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}