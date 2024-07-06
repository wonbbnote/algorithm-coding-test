class Solution {
    
    public boolean isValid(int r, int c, int[][] board){
        return (r >= 0 && r < board.length) && (c >= 0 && c < board[0].length) && board[r][c] == 0;
    }
    
    public int solution(int[][] board) {
        int[] dr = {-1, 0, 1, 0, -1, -1, 1, 1};
        int[] dc = {0, 1, 0, -1, -1, 1, 1, -1};

        int answer = 0;
        
        int unsafeZone = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 1){
                    unsafeZone++;
                    for(int s = 0; s < 8; s++){
                        int nextRow = i + dr[s];
                        int nextCol = j + dc[s];
                        if(isValid(nextRow, nextCol, board)){
                            board[nextRow][nextCol] = 2;
                            unsafeZone++;
                        }
                    }
                }
            }
        }
        // System.out.println(unsafeZone);
        answer = board.length * board[0].length - unsafeZone;
        
        
        
        return answer;
    }
}