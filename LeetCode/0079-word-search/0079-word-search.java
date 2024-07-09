class Solution {
    // -> [0, 1], 아래 [1, 0], 위[-1, 0], <- [0, -1]
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length;j++){
                boolean[][] visited = new boolean[board.length][board[0].length];
                boolean result = backtracking(i, j, 0, board, word, visited);
                if(result){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtracking(int m, int n, int nth_char, char[][] board, String word, boolean[][] visited){
        
        if(word.charAt(nth_char) == board[m][n]){
            visited[m][n] = true;

            if(nth_char == word.length()-1){
                return true;

            }else{
            
                if(n < board[0].length - 1 && visited[m][n+1] == false){
                    if(backtracking(m, n+1, nth_char+1, board, word, visited)){
                        return true;
                    }else{
                        visited[m][n+1] = false;
                    }; // 오른쪽
                }

                if(n > 0 && visited[m][n-1] == false){
                    if(backtracking(m, n-1, nth_char+1, board, word, visited)){
                        return true;
                    }else{
                        visited[m][n-1] = false;
                    }; // 왼쪽
                }

                if(m > 0 && visited[m-1][n] == false){
                    if(backtracking(m-1, n, nth_char+1, board, word, visited)){
                        return true;
                    }else{
                        visited[m-1][n] = false;
                    }; // 위쪽
                }

                if(m < board.length - 1 && visited[m+1][n] == false){
                    if(backtracking(m+1, n, nth_char+1, board, word, visited)){
                        return true;
                    }else{
                        visited[m+1][n] = false;
                    }; // 아래쪽
                }
            }
        }
        return false;
        
    }
}