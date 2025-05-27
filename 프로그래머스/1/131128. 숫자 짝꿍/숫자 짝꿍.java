import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        
        Map<Character, Integer> mapX = new HashMap<>();
        
        for(int i = 0; i < X.length(); i++){
            Character c = X.charAt(i);
            if(!mapX.containsKey(c)){
                mapX.put(c, 1);
            }else{
                mapX.put(c, mapX.get(c) + 1);
            }
        }
        
        List<String> res = new ArrayList<>();
        for(int i = 0; i < Y.length(); i++){
            Character c = Y.charAt(i);
            if(mapX.containsKey(c) && mapX.get(c) > 0){
                res.add(c + "");
                mapX.put(c, mapX.get(c) - 1);
            }
        }
        
        Collections.sort(res, Collections.reverseOrder());
        
        if(res.size() == 0){
            return "-1";
        }else{
            boolean zero = true;
            for(String s : res){
                if(!s.equals("0")){
                    zero = false;
                }
                answer.append(s);
            }
            if(zero){
                return "0";
            }else{
                return answer.toString();
            }
        }
        
    }
}