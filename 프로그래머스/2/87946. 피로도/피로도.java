import java.util.*;

class Solution {
    
    static int answer;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        visited = new boolean[dungeons.length];
        backtracking(k, dungeons, 0);
        
        return answer;
    }
    
    public void backtracking(int k, int[][] dungeons, int num){
        
        answer = Math.max(answer, num);
        
        for(int i = 0; i < dungeons.length; i++){
            if(k >= dungeons[i][0] && !visited[i]){
                visited[i] = true;
                backtracking(k - dungeons[i][1], dungeons, num+1);
                visited[i] = false;
            }
        }
    }
}