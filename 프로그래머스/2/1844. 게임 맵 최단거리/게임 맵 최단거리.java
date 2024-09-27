import java.util.*;
class Solution {
    private static int[][] visited;
    private static int[] rs = {-1, 0, 1, 0};
    private static int[] cs = {0, -1, 0, 1};
    
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        visited = new int[n][m];
        answer = bfs(0, 0, maps);
        
        return answer;
    }
    
    private boolean isValid(int r, int c, int[][] maps){
        return (r >= 0 && r < maps.length) && (c >= 0 && c < maps[0].length) && maps[r][c] == 1;
    }
    
    private int bfs(int r, int c, int[][] maps){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {r, c});
        visited[r][c] = 1;
        int answer = 0;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            
            if(curr[0] == visited.length-1 && curr[1] == visited[0].length-1){
                return visited[curr[0]][curr[1]];
            }
            
            for(int i = 0; i < 4; i++){
                int next_r = curr[0] + rs[i];
                int next_c = curr[1] + cs[i];
                
                if(isValid(next_r, next_c, maps)){
                    if(visited[next_r][next_c] == 0){
                        queue.add(new int[] {next_r, next_c});
                        visited[next_r][next_c] = visited[curr[0]][curr[1]] + 1;
                    }
                    
                }
            }
            
        }
        
        return -1;
        
        
    }
}