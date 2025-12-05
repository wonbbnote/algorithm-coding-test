import java.util.*;
class Solution {
    static int maxLen = 0;
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        Queue<int[]>[] recordQ = new LinkedList[routes.length];
        
        for(int i = 0; i < routes.length; i++){
            recordQ[i] = new LinkedList<>();
            recordQ[i].add(new int[] {points[routes[i][0] - 1][0], points[routes[i][0] - 1][1]});
            for(int j = 0; j < routes[0].length - 1; j++){
                int x1 = points[routes[i][j] - 1][0];
                int y1 = points[routes[i][j] - 1][1];
                int x2 = points[routes[i][j+1] - 1][0];
                int y2 = points[routes[i][j+1] - 1][1];
                record(x1, y1, x2, y2, recordQ[i]);
            }
            
        }
        
        int count = 0;
        int res = 0;
        while(count < maxLen){
            int[][] map = new int[101][101];
            
            for(int i = 0; i < routes.length; i++){
                if(recordQ[i].isEmpty()) continue;
                int[] robot = recordQ[i].poll();
                map[robot[0]][robot[1]]++;
            }
            
            
            for(int i = 0; i < 101; i++){
                for(int j = 0; j < 101; j++){
                    if(map[i][j] >= 2){
                        //System.out.println("== 결과 ==");
                        //System.out.println("x1: " + i + ", y1: " + j);
                        res++;
                    }
                }
            }
            
            count++;
        }
        
        return res;
    }
    
    public void record(int x1, int y1, int x2, int y2, Queue<int[]> q){
        
        //System.out.println("x1: " + x1 + ", y1: " + y1);
        int xMove = x1 < x2 ? 1 : -1;
        int xDiff = Math.abs(x1 - x2);
        int yMove = y1 < y2 ? 1 : -1;
        int yDiff = Math.abs(y1 - y2);
        
        for(int i = 0; i < xDiff; i++){
            x1 += xMove;
            q.add(new int[] {x1, y1});
            //System.out.println("x1: " + x1 + ", y1: " + y1);
        }
        
        for(int i = 0; i < yDiff; i++){
            y1 += yMove;
            q.add(new int[] {x1, y1});
            //System.out.println("x1: " + x1 + ", y1: " + y1);
        }
        
        //System.out.println("=====");
        
        maxLen = Math.max(maxLen, q.size());
    }
}