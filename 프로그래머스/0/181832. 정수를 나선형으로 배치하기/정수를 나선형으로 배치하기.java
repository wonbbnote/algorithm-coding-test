import java.util.*;
class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int idx = 0;
        int[] row = {1, 0, -1, 0};
        int[] col = {0, 1, 0, -1};
        
        int x = 0;
        int y = 0;
        for(int i = 1; i <= Math.pow(n,2); i++){
            answer[y][x] = i;
            
            if(idx == 0 && (x == n-1 || answer[y+col[idx]][x+row[idx]] != 0)){
                idx += 1;
            }else if(idx == 1 && (y == n-1 || answer[y+col[idx]][x+row[idx]] != 0)){
                idx += 1;
            }else if(idx == 2 && (x == 0 || answer[y+col[idx]][x+row[idx]] != 0)){
                idx += 1;
            }else if(idx == 3 && (y == 0 || answer[y+col[idx]][x+row[idx]] != 0)){
                idx = 0;
            }
            y += col[idx];
            x += row[idx];
                
            
            
        }
        
        return answer;
    }
}