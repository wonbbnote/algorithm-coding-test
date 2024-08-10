import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Map<String, Integer> map = new HashMap<>();
        
        int res = 0;
        String next = words[0];
        map.put(words[0], 1);
        
        for(int i = 1; i < words.length; i++){
            // 끝말을 잘 이었는가?
            String beforeEnd = next.substring(next.length() - 1);
            String currEnd = words[i].substring(0, 1);
            if(!beforeEnd.equals(currEnd)){
                res = i;
                break;
            }
            
            // 이미 언급된 단어인가? 
            if(!map.containsKey(words[i])){
                map.put(words[i], 1);
            }else{
                res = i;
                break;
            }
            
            // 다음 단어 저장하기
            next = words[i];
        }
        
        if(res != 0){
            answer[0] = res % n + 1;
            answer[1] = res / n + 1;
        }
        
        return answer;
    }
}