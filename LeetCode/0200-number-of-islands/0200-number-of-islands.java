import java.util.*;
class Solution {
    static boolean[][] visited;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];

        int islands = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(i, j, visited, grid);
                    islands += 1;
                }
            }
        }
        return islands;
    }

    public void dfs(int row, int col, boolean[][] visited, char[][] grid){
        visited[row][col] = true;
        int m = visited.length;
        int n = visited[0].length;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for(int i = 0; i < 4; i++){
            int nextRow = row + dr[i];
            int nextCol = col + dc[i];
            if((0 <= nextRow && nextRow < m) && (0 <= nextCol && nextCol < n) && grid[nextRow][nextCol] == '1'){
                if(!visited[nextRow][nextCol]){
                    dfs(nextRow, nextCol, visited, grid);
                }
            }
        }
    }

}