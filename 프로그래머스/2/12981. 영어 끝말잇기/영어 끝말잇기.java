import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        String end = words[0].substring(words[0].length()-1);
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        
        int idx = 0;
        for(int i = 1; i < words.length; i++){
            if(words[i].length() == 1){
                idx = i;
                break;
            }
            String first = words[i].substring(0, 1);
            if(!end.equals(first)){
                idx = i;
                break;
            }
            if(set.contains(words[i])){
                idx = i;
                break;
            }
            
            end = words[i].substring(words[i].length()-1);
            set.add(words[i]);
            
        }
        
        if(idx != 0){
            answer[0] = idx % n + 1;
            answer[1] = idx / n + 1;
        }

        return answer;
    }
}