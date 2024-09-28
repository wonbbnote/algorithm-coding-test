import java.util.*;
class Solution {
    
    private static boolean[] visited;
    private static ArrayList<Integer>[] adjList;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        adjList = new ArrayList[n+1];
        for(int i = 1; i < adjList.length; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] e: edge){
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }
        
        visited = new boolean[n+1];
        answer = bfs(1);

        return answer;
    }
    
    private int bfs(int start){
        int answer = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        queue.add(new int[] {start, 0});
        visited[start] = true;
        int maxDis = 0;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            map.put(curr[0], curr[1]);
            
            for(int next: adjList[curr[0]]){
                if(!visited[next]){
                    queue.add(new int[] {next, curr[1]+1});
                    visited[next] = true;
                    maxDis = Math.max(maxDis, curr[1]+1);
                }
            }
        }
        System.out.println(maxDis);
 
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            // if(entry.getValue() == Collections.max(map.values())){
            if(entry.getValue() == maxDis){
                answer++;
            }
        }
        return answer;
    }
}