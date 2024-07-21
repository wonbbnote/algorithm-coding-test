class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        // n * n 크기 체스판 board를 만든다
        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row, '.');
        }

        // 0번 행부터 적합한 여왕의 위치를 찾기 시작한다.(재귀함수)
        Queens(0, board, res, n);

        return res;
    }

    private void Queens(int r, char[][] board, List<List<String>> res, int n){
        // 행 번호가 n 이라면 res에 정답을 추가한다.
        if(r == n){
            res.add(constructSolution(board));
            return;
        }


        for(int col = 0; col < n; col++){
            if(isValid(board, r, col, n)){
                board[r][col] = 'Q';        // board[r][col]를 Q로 변경
                Queens(r+1, board, res, n); // 다음 행으로 이동
                board[r][col] = '.';        // board[r][col]를 다시 빈칸으로 변경
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col, int n){
        // 열 확인
        for(int i = 0; i < row; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // 왼쪽 대각선 확인
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        // 오른쪽 대각선 확인
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;

    }

    private List<String> constructSolution(char[][] board){
        List<String> solution = new ArrayList<>();
        for(char[] row: board){
            solution.add(new String(row));
        }
        return solution;
    }
}