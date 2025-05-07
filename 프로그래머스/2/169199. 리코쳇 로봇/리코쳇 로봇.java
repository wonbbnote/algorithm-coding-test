import java.util.*;

class Solution {
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public int solution(String[] board) {
        
        // R과 G의 위치를 찾기
        int[] R = new int[2];
        int[] G = new int[2];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length(); j++){
                char c = board[i].charAt(j);
                if(c == 'R'){
                    R = new int[] {i, j};
                }else if(c == 'G'){
                    G = new int[] {i, j};
                }
            }
        }
        
        // 상하좌우로 갈 수 있는 방향으로 가기 D를 만나거나 가장자리까지 부딪힐때까지 미끄러짐
        // 멈추는 위치 큐에 넣기
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {R[0], R[1], 0});
        boolean[][] visited = new boolean[board.length][board[0].length()];
        visited[R[0]][R[1]] = true;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            
            if(curr[0] == G[0] && curr[1] == G[1]){
                return curr[2];
            }
            
            for(int i = 0; i < 4; i++){
                int next_x = curr[0] + dx[i];
                int next_y = curr[1] + dy[i];
                
                if(isValid(next_x, next_y, board)){
                    
                    while(isValid(next_x + dx[i], next_y + dy[i], board)){
                        next_x += dx[i];
                        next_y += dy[i];
                    }
                    
                    if(!visited[next_x][next_y]){
                        visited[next_x][next_y] = true;
                        queue.add(new int[] {next_x, next_y, curr[2] + 1});
                    }
                }  
            }
        }
        
        return -1;
    }
    
    public boolean isValid(int x, int y, String[] board){
        return (x >= 0 && x < board.length) && (y >= 0 && y < board[0].length()) 
            &&  board[x].charAt(y) != 'D';
    }
    
    
}