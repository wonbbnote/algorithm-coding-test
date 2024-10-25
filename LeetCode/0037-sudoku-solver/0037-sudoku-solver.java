class Solution {

    private static class Block{
        int i, j;
        public Block(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    private static char[][] Board;

    private static boolean isValid(int num, int row, int col){
        return !(inRow(num, row) || inCol(num, col) || inBox(num, row, col));
    }

    private static boolean inRow(int num, int row){
        for(int i = 0; i < 9;i++){
            if(Board[row][i] == (char) (num + '0')) return true;
        }
        return false;
    }
    private static boolean inCol(int num, int col){
        for(int i = 0; i < 9;i++){
            if(Board[i][col] == (char) (num + '0')) return true;
        }
        return false;
    }
    private static boolean inBox(int num, int row, int col){
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;

        for(int i = boxRow; i < boxRow + 3; i++){
            for(int j = boxCol; j < boxCol + 3; j++){
                if(Board[i][j] == (char) (num + '0')) return true;
            }
        }
        return false;
    }

    private static Block findEmptyPosition(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(Board[i][j] == '.') return new Block(i, j);
            }
        }
        return null;
    }

    private static boolean findSolution(){
        Block emptyPos = findEmptyPosition();
        if(emptyPos == null) return true;

        int row = emptyPos.i;
        int col = emptyPos.j;

        for(int num = 1; num <= 9; num++){
            if(isValid(num, row, col)){
                Board[row][col] = (char) (num + '0');
                if(findSolution()) return true;
                Board[row][col] = '.';
            }
        }
        return false;
    }

    public char[][] solveSudoku(char[][] board) {
        Board = board;
        findSolution();
        return board;
    }
}