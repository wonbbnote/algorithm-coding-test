import java.util.*;
class Solution {
    
    public int solution(int n, int[][] computers) {
        Map<Integer, Boolean> visited = new HashMap<>();
        int answer = 0;
        
        for(int i = 0; i < n; i++){
            if(!visited.containsKey(i)){
                dfs(n, i, visited, computers);
                answer += 1;
            }
        }
        return answer;
    }
    
    static void dfs(int n, int cur, Map<Integer, Boolean> visited, int[][] computers){
        visited.put(cur, true);
        for(int i = 0; i < n; i++){
            if(computers[cur][i] == 1 && !visited.containsKey(i)){
                dfs(n, i, visited, computers);
            }
        }
    }
}