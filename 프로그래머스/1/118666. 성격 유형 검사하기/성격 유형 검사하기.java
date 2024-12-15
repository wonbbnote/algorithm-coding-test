import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        
        for(int i = 0; i < survey.length; i++){
            char[] type = survey[i].toCharArray();
            int choice = choices[i];
            
            if(choice < 4){
                int added = 4 - choice;
                map.put(type[0], map.get(type[0]) + added);

            }else if(choice > 4){
                int added = choice - 4;
                map.put(type[1], map.get(type[1]) + added);
            }            
        }
        
        char[] a = {'R', 'C', 'J', 'A'};
        char[] b = {'T', 'F', 'M', 'N'};
        
        for(int i = 0; i < 4; i++){
            char t1 = a[i];
            char t2 = b[i];
            if(map.get(t1) > map.get(t2)){
                answer += t1;
            }else if(map.get(t1) < map.get(t2)){
                answer += t2;
            }else{
                if(t1 < t2){
                    answer += t1;
                }else{
                    answer += t2;
                }
            }
            
        }
        
        return answer;
    }
}