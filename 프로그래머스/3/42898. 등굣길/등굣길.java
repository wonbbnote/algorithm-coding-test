import java.util.*;
class Solution {
    
    private static int[][] mem = new int[101][101];
    
    public int solution(int m, int n, int[][] puddles) {
        for(int[] row: mem){
            Arrays.fill(row, -1);
        }
        
        boolean[][] isPuddle = new boolean[m+1][n+1];
        for(int[] puddle: puddles){
            isPuddle[puddle[0]][puddle[1]] = true;
        }

        return recursion(1, 1, m, n, isPuddle);
    }
    
    public int recursion(int x, int y, int m, int n, boolean[][] isPuddle){
        if(x > m || y > n) return 0;
        if(isPuddle[x][y]) return 0;
        if(x == m && y == n) return 1;
        if(mem[x][y] != -1) return mem[x][y];
        
        int total = recursion(x+1, y, m, n, isPuddle) + recursion(x, y+1, m, n, isPuddle);
        mem[x][y] = total % 1_000_000_007;
        return mem[x][y];
        
    }
}