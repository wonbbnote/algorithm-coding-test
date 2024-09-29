import java.util.*;
class Solution {
    private static boolean[] visited;
    private static ArrayList<Integer>[] adjList;
    private static int N, answer;
    
    public int solution(int n, int[][] wires) {
        N = n;
        answer = n-1;
        
        adjList = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < wires.length; i++){
            adjList[wires[i][0]].add(wires[i][1]);
            adjList[wires[i][1]].add(wires[i][0]);
        }
        
        visited = new boolean[n+1];
        dfs(1);
        
        
        return answer;
    }
    
    private int dfs(int now){
        visited[now] =true;
        int sum = 0;
        for(int next: adjList[now]){
            if(!visited[next]){
                int cnt = dfs(next);
                answer = Math.min(answer, Math.abs(N-cnt*2));
                sum += cnt;
            }
        }
        return sum + 1;
    }
    
    
    
}