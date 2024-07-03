import java.util.*;
class Solution {
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    public boolean isValid(int r, int c, int[][] maps){
        return (r >= 0 && r < maps.length) && (c >= 0 && c < maps[0].length) && maps[r][c] == 1;
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int m = maps.length;
        int n = maps[0].length;
        visited = new boolean[m][n];
        
        answer = bfs(0,0,1, maps);
        
        return answer;
    }
    
    public int bfs(int m, int n, int dis, int[][] maps){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {m, n, dis});
        visited[m][n] = true;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int curRow = curr[0];
            int curCol = curr[1];
            int curDis = curr[2];
            
            if(curRow == maps.length-1 && curCol == maps[0].length-1){
                return curDis;
            }
            
            for(int i = 0 ; i < 4; i++){
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];
                if(isValid(nextRow, nextCol, maps)){
                    if(!visited[nextRow][nextCol]){
                        visited[nextRow][nextCol] = true;
                        queue.offer(new int[] {nextRow, nextCol, curDis+1});
                    }
                }
            }
        }
        return -1;
        
    }
}