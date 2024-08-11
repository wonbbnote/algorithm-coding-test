import java.util.*;
class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        
        boolean res = false;
        for(String d: dic){
            
            List<String> spellList = new ArrayList(Arrays.asList(spell));
            
            for(int i = 0; i < d.length(); i++){
                String str = d.substring(i, i+1);
                if(spellList.contains(str)){
                    spellList.remove(str);
                }
            }
            
            if(spellList.size() == 0){
                res = true;
                break;
            }
        }
        
        if(res){
            answer = 1;
        }
        
        return answer;
    }
}