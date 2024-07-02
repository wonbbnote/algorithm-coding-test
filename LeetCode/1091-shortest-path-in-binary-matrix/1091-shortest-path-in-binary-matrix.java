class Solution {
    static boolean[][] visited;
    static int[] dr = {-1, 0, 0, 1, -1, 1, -1, 1};
    static int[] dc = {0, 1, -1, 0, 1, 1, -1, -1};

    public boolean isValid(int r, int c, int[][] grid){
        return (r >= 0 && r < grid.length) && (c >= 0 && c < grid[0].length) && grid[r][c] == 0;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int answer = 0;
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];

        if(grid[0][0] == 0){
            return bfs(0, 0, 1, grid);
        }

        return -1;
    
    }
    public int bfs(int r, int c, int dis, int[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c, dis});
        visited[r][c] = true;

        int cycle = 0;
        while(!queue.isEmpty()){
            
            int[] curr = queue.poll();
            int curRow = curr[0];
            int curCol = curr[1];
            int curDis = curr[2];

            if(curRow == grid.length-1 && curCol == grid[0].length-1){
                return curDis;
            }
            cycle++;

            for(int i = 0; i < 8; i++){
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];

                if(isValid(nextRow, nextCol, grid)){
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