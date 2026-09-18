class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int max;
    static int[][] rottenSec;

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        rottenSec = new int[n][m];

        max = 0;

        Queue<int[]> queue = new ArrayDeque<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[] {i, j, 0});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] polled = queue.poll();

            for(int k = 0; k < 4; k++){
                int nextX = polled[0] + dx[k];
                int nextY = polled[1] + dy[k];

                if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m){
                    if(grid[nextX][nextY] == 1 && rottenSec[nextX][nextY] == 0){
                        rottenSec[nextX][nextY] = polled[2] + 1;
                        queue.offer(new int[] {nextX, nextY, polled[2] + 1});
                        max = Math.max(max, polled[2] + 1);
                    }
                }
            }
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && rottenSec[i][j] == 0){
                    return -1;
                }
            }
        }

        return max;
    }
}