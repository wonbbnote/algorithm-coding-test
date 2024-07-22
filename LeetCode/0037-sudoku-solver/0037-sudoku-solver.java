class Solution {
    public void solveSudoku(char[][] board) {
        char[][] copy = new char[board.length][];
        for (int i = 0; i < board.length; i++) {
            copy[i] = board[i].clone();
        }

        backtrack(copy, 0);

        for (int i = 0; i < board.length; i++) {
            board[i] = copy[i].clone();
        }
    }

    boolean backtrack(char[][] board, int n) {
				//✅ 모든 칸에 올바르게 숫자를 부여했다면 true를 반환한다.
        if (n == 81) return true;

        int r = n / 9,
            c = n % 9;
				//✅ 현재 위치(i, j)가 비어있지 않다면, 다음 위치로 넘어간다. (재귀 함수 호출)
        if (board[r][c] != '.') return backtrack(board, n+1);
				//✅ 현재 위치(i, j)가 비어있는지 검사한다.
        else {
						//✅ 현재 위치에 1 ~ 9 사이의 정수를 부여해본다.
            for (int i = 0; i < 9; i++) {
                char nextValue = (char)(49 + i);
								//✅ 현재 위치에 선택한 정수의 유효성을 검사한다.
                if (!isValid(board, r, c, nextValue)) continue;
	              //✅ board[i][j]에 유효한 정수를 부여한다.
                board[r][c] = nextValue;
								//✅ 백트래킹을 수행한다. (재귀 함수 호출)
                if (backtrack(board, n+1)) return true;
								//✅ False가 반환되면, board[i][j]를 빈 칸으로 되돌린다.
                board[r][c] = '.';
            }
        }

        return false;
    }

    boolean isValid(char[][] board, int r, int c, char value) {
        // 행 확인
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == value) return false;
        }
        // 열 확인
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == value) return false;
        }
        // 3x3 sub-box 확인
        int sr = (r / 3) * 3,
            sc = (c / 3) * 3;
        for (int dr = 0; dr < 3; dr++) {
            for (int dc = 0; dc < 3; dc++) {
                if (board[sr+dr][sc+dc] == value) return false;
            }
        }
        return true;
    }
}