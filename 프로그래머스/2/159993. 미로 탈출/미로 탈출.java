import java.util.*;
class Solution {
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, -1, 0, 1};
    
    
    public int solution(String[] maps) {
        int answer = 0;
        
        
        int[] S_loca = {};
        int[] L_loca = {};
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                if(maps[i].charAt(j) == 'S'){
                    S_loca = new int[] {i, j};
                }else if(maps[i].charAt(j) == 'L'){
                    L_loca = new int[] {i, j};
                }
            }
        }
        
        int first = bfs(S_loca[0], S_loca[1], 'L', maps);
        int second = bfs(L_loca[0], L_loca[1], 'E', maps);
        
        if(first == -1 || second == -1){
            return -1;
        }else{
            return first+second;
        }

    }
    
    public boolean isValid(int r, int c, String[] maps){
        return (r >= 0 && r < maps.length) && (c >= 0 && c < maps[0].length()) && maps[r].charAt(c) != 'X';
    }
    
    public int bfs(int r, int c, char dest, String[] maps){
        int[][] visited = new int[maps.length][maps[0].length()];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {r, c});
        visited[r][c] = 1;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            
            if(maps[curr[0]].charAt(curr[1]) == dest){
                return visited[curr[0]][curr[1]] - 1;
            }
            
            for(int i = 0; i < 4; i++){
                int next_r = curr[0] + dr[i];
                int next_c = curr[1] + dc[i];
                
                if(isValid(next_r, next_c, maps)){
                    if(visited[next_r][next_c] == 0){
                        queue.add(new int[] {next_r, next_c});
                        visited[next_r][next_c] = visited[curr[0]][curr[1]] + 1;
                    }
                }
            }
            // for(int i = 0; i < visited.length; i++){
            //     System.out.println(Arrays.toString(visited[i]));
            // }
            
        }
        
        return -1;
        
    }
}