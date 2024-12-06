import java.util.*;
class Solution {
    public class Node{
        int dest, cost;
        
        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        ArrayList<Integer>[] adjList = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < roads.length; i++){
            adjList[roads[i][0]].add(roads[i][1]);
            adjList[roads[i][1]].add(roads[i][0]);
        }
        
            
        int[] dist = new int[n+1];
        int inf = Integer.MAX_VALUE;
        Arrays.fill(dist, inf);
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        dist[destination] = 0;
        pq.add(new Node(destination, 0));

        int dis = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(now.cost > dist[now.dest]){
                continue;
            }

            for(int next : adjList[now.dest]){
                if(dist[next] > now.cost + 1){
                    dist[next] = now.cost + 1;
                    pq.add(new Node(next, dist[next]));
                }
            }
        }

        for(int i = 0; i < sources.length; i++){
            if(dist[sources[i]] == inf){
               answer[i] = -1;
            }else{
                answer[i] = dist[sources[i]];
            }
        }
        
        return answer;
    }
}