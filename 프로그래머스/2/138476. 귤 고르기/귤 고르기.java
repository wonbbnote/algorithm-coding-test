import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Arrays.sort(tangerine);

        Map<Integer, Integer> map = new HashMap<>();
        for(int a = 0; a < tangerine.length; a++){
            if(!map.containsKey(tangerine[a])){
                map.put(tangerine[a], 1);
            }else{
                map.put(tangerine[a], map.get(tangerine[a]) + 1);
            }
        }

        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        for (Integer key : keySet) {
            k -= map.get(key);
            answer++;
            if(k <= 0){
                break;
            }
        }
        
        
        return answer;
    }
}