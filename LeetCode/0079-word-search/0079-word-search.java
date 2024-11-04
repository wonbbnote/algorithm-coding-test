class Solution {

    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {-1, 0, 1, 0};


    public boolean exist(char[][] board, String word) {

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                boolean[][] visited = new boolean[board.length][board[0].length];
                visited[i][j] = true;
                if(search(board, i, j, 0, word, visited)){
                    return true;
                }
            }
        }
        return false;
        
    }

    private boolean isValid(char[][] board, int row, int col, boolean[][] visited){
        return (row >= 0 && row < board.length) && (col >= 0 && col < board[0].length) && !visited[row][col];

    }

    private boolean search(char[][] board, int row, int col, int idx, String word, boolean[][] visited){
        
        if(board[row][col] == word.charAt(idx)){

            if(idx + 1 == word.length()){
                return true;
            }

            for(int i = 0; i < 4; i++){
                int nextRow = row + dx[i];
                int nextCol = col + dy[i];

                if(isValid(board, nextRow, nextCol, visited)){
                    visited[nextRow][nextCol] = true;
                    if(search(board, nextRow, nextCol, idx+1, word, visited)){
                        return true;
                    }
                    visited[nextRow][nextCol] = false;
                }
            }
        }

        return false;
    }
}