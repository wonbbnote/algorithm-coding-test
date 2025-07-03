import java.util.*;

class Solution {
    
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    
    public int solution(int[][] land) {
        int answer = 0;
        
        int[][] visited = new int[land.length][land[0].length];
        Map<Integer, Integer> map = new HashMap<>();
        
        int label = 1;
        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land[0].length; j++){
                if(land[i][j] == 1 && visited[i][j] == 0){
                    visited[i][j] = label;
                    int size = bfs(land, visited, i, j, label);
                    map.put(label, size);
                    label++;
                }
            }
        }
        
        // 열별로 최댓값 확인
        for(int col = 0; col < land[0].length; col++){
            Set<Integer> set = new HashSet<>();
            int resources = 0;
            for(int row = 0; row < land.length; row++){
                if(visited[row][col] != 0){
                    set.add(visited[row][col]);
                }
            }
            for(int num : set){
                resources += map.get(num); 
            }
            answer = Math.max(answer, resources);
        }
        
        return answer;
    }
    
    public int bfs(int[][] land, int[][] visited, int x, int y, int label){
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {x, y});
        int size = 1;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nextX = curr[0] + dx[i];
                int nextY = curr[1] + dy[i];
                
                if(isValid(nextX, nextY, land) && visited[nextX][nextY] == 0){
                    visited[nextX][nextY] = label;
                    queue.add(new int[] {nextX, nextY});
                    size++;
                }
            }
        }
        
        return size;
        
    }
    
    public boolean isValid(int nextX, int nextY, int[][] land){
        return (nextX >= 0 && nextX < land.length) 
            && (nextY >= 0 && nextY < land[0].length)
            && land[nextX][nextY] == 1;
    }
}