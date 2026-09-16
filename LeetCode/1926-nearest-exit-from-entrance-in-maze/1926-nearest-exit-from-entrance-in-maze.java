class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int nearestExit(char[][] maze, int[] entrance) {

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        queue.offer(new int[] {entrance[0], entrance[1], 0});
        visited[entrance[0]][entrance[1]] = true;
        System.out.println("nowX: " + entrance[0] + ", nowY: " + entrance[1]);

        while(!queue.isEmpty()){
            int[] polled = queue.poll();
            int nowX = polled[0];
            int nowY = polled[1];
            int step = polled[2];

            if(nowX == 0 || nowX == maze.length-1 || nowY == 0 || nowY == maze[0].length - 1){
                if(nowX != entrance[0] || nowY != entrance[1]){
                    return step;
                }
            }

            for(int i = 0; i < 4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX >= 0 && nextX < maze.length && nextY >= 0 && nextY < maze[0].length){
                    if(!visited[nextX][nextY] && maze[nextX][nextY] == '.'){
                        visited[nextX][nextY] = true;
                        queue.offer(new int[] {nextX, nextY, step+1});
                    }
                }
            }
        }

        return -1;
        
    }
}