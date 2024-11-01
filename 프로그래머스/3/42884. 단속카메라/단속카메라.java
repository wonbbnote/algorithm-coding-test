import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, Comparator.comparingInt((int[] o) -> o[1]));
        
        boolean[] met = new boolean[routes.length];
        
        int idx = 0;
        for(int i = 0; i < routes.length; i++){

            if(met[i]){
                continue;
            }
            int camera = routes[i][1];
            answer++;
            
            for(int j = i+1; j < routes.length; j++){
                if(routes[j][0] <= camera && routes[j][1] >= camera){
                    met[j] = true;
                }else{
                    break;
                }
            }
        }
        
        
        
        return answer;
        
    }
}