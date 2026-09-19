import java.util.*;
class Solution {
    public static class Node{
        int dest, cost;
        
        Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        ArrayList<Node>[] adjList = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < road.length; i++){
            adjList[road[i][0]].add(new Node(road[i][1], road[i][2]));
            adjList[road[i][1]].add(new Node(road[i][0], road[i][2]));
        }
        
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        // System.out.println(Arrays.toString(dist));
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(1, 0));
        
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            
            if(dist[curr.dest] < curr.cost){
                continue;
            }
            
            for(Node next : adjList[curr.dest]){
                if(dist[next.dest] > curr.cost + next.cost){
                    dist[next.dest] = curr.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
                
            }
            
        }
                
        for(int i = 1; i <= N; i++){
            if(dist[i] <= K){
                answer++;
            }
        }

        return answer;
    }
}