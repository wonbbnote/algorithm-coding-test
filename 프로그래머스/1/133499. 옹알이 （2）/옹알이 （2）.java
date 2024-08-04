import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] possible = {"aya", "ye", "woo", "ma"};
        
        
        for(int i = 0; i < babbling.length; i++){
            for(int j = 0; j < possible.length; j++){
                if(babbling[i].contains(possible[j])){
                    babbling[i] = babbling[i].replace(possible[j], j + "");
                }
            }
            
            boolean duplicated = true;
            for(int j = 0; j < babbling[i].length(); j++){
                String str = babbling[i].substring(j, j+1);
                if(str.matches("[0-9.]+")){
                    if(j > 0){
                        String beforeStr = babbling[i].substring(j-1, j);
                        if(beforeStr.equals(str)){
                            duplicated = false;
                        }
                    }
                }else{
                    duplicated = false;
                }
            }
            
            if(duplicated){
                answer++;
            }
        }
        
        
        
        return answer;
    }
}