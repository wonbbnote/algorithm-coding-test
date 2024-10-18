import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {

        // 귤 개수 map으로 만들기
        Map<Integer, Integer> tangerine_db = new HashMap<>();
        for(Integer length: tangerine){
            if(tangerine_db.containsKey(length)){
                tangerine_db.replace(length, tangerine_db.get(length)+1);
            }else{
                tangerine_db.put(length, 1);
            }
        }
        
        // value값으로 정렬한 key 리스트 만들기
        List<Integer> keys = new ArrayList<>(tangerine_db.keySet());
		Collections.sort(keys, (v2, v1) -> (tangerine_db.get(v1).compareTo(tangerine_db.get(v2)))); 
        
        // 개수 리턴
        int answer = 0;
        int num = k;
		for (Integer key : keys) {
            if(num <= 0){
                break;
            }
            num -= tangerine_db.get(key);
            answer += 1;
		}
        
        
        return answer;
    }
}