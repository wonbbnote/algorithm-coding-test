import java.util.*;
class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    
    public int solution(int[][] land) {
        int answer = 0;
        
        int n = land.length;
        int m = land[0].length;
        
        boolean[][] visited = new boolean[n][m];
        board = new int[n][m];
        Map<Integer, Integer> map = new HashMap<>();
        
        int tag = 10;
        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land[0].length; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    int total = bfs(i, j, n, m, tag, visited, land);
                    map.put(tag, total);
                    tag++;
                }
            }
        }
        
        int max = 0;
        
        for(int j = 0; j < board[0].length; j++){
            Set<Integer> set = new HashSet<>();
            int caseTotal = 0;
            for(int i = 0; i < board.length; i++){
                if(board[i][j] != 0){
                    set.add(board[i][j]);
                }
            }
            for(int s: set){
                caseTotal += map.get(s);
            }
            max = Math.max(caseTotal, max);
        }
        
        return max;
    }
    
    public int bfs(int x, int y, int n, int m, int tag, boolean[][] visited, int[][] land){
        int total = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            board[curr[0]][curr[1]] = tag;
            total++;
            
            for(int i = 0; i < 4; i++){
                int nextX = curr[0] + dx[i];
                int nextY = curr[1] + dy[i];
                
                if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m){
                    if(!visited[nextX][nextY] && land[nextX][nextY] == 1){
                        visited[nextX][nextY] = true;
                        queue.add(new int[] {nextX, nextY});
                    }
                }
            }
        }
        
        return total;
    }
}