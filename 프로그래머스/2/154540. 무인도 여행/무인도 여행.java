import java.util.*;
class Solution {
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, -1, 0, 1};
    static int days = 0;
    
    public boolean isValid(int x, int y, boolean[][] visited){
        return (x >= 0 && x < visited.length) && (y >= 0 && y < visited[0].length);
    }
    
    public int[] solution(String[] maps) {
        List<Integer> results = new ArrayList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                days = 0;
                if(!visited[i][j]){
                    dfs(i, j, visited, maps);
                    System.out.println("========");
                    if(days > 0){
                        results.add(days);
                    }
                }
            }
        }

        if(results.size() == 0){
            return new int[] {-1};
        }
        
        int[] answer = results.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
        
        
    }
    
    public void dfs(int x, int y, boolean[][] visited, String[] maps){
        if(maps[x].charAt(y) != 'X'){
            visited[x][y] = true;
            days += maps[x].charAt(y) - '0';
        
            for(int i = 0; i < 4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(isValid(nextX, nextY, visited)){
                    if(maps[nextX].charAt(nextY) != 'X' && !visited[nextX][nextY]){
                        // System.out.println(maps[nextX].charAt(nextY));
                        // days += maps[nextX].charAt(nextY) - '0';
                        dfs(nextX, nextY, visited, maps);
                    }
                }
            }
        }
            
        
    }
}