import java.util.*;
class Solution {
    private boolean isValid(int x, int y){
        return (x >= 0 && x <= 10) && (y >= 0 && y <= 10);
    }
    
    public int solution(String dirs) {
        
        char[] dirsArr = dirs.toCharArray();
        
        Map<Character, int[]> command = new HashMap<>();
        command.put('U', new int[] {-1, 0});
        command.put('D', new int[] {1, 0});
        command.put('R', new int[] {0, 1});
        command.put('L', new int[] {0, -1});
        
        int[] now = new int[] {5, 5};
        
        HashSet<String> answer = new HashSet<>();
        
        for(int i = 0; i < dirsArr.length; i++){
            int x = now[0] + command.get(dirsArr[i])[0];
            int y = now[1] + command.get(dirsArr[i])[1];
            
            if(isValid(x, y)){

                answer.add(now[0] + " "+ now[1]+ " " + x + " "+ y);
                answer.add(x + " " + y + " " + now[0] + " " + now[1]);
                
                now[0] = x;
                now[1] = y;
            }
        }
        
        return answer.size()/2;
    }
}