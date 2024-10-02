import java.util.*;
class Solution {
    
    private static class Node{
        int dest, cost;
        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        ArrayList<Node>[] adjList = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            adjList[i] = new ArrayList<>();
        }
        for(int[] fare: fares){
            adjList[fare[0]].add(new Node(fare[1], fare[2]));
            adjList[fare[1]].add(new Node(fare[0], fare[2]));
        }
        
        int[][] dist = new int[3][n+1];
        int[] cases = {s, a, b};
        for(int i = 0; i < 3; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        for(int i = 0 ; i < 3; i++){
        
            pq.add(new Node(cases[i], 0));
            dist[i][cases[i]] = 0;

            while(!pq.isEmpty()){
                Node now = pq.poll();
                if(dist[i][now.dest] < now.cost) continue;
                for(Node next: adjList[now.dest]){
                    if(dist[i][next.dest] > now.cost + next.cost){
                        dist[i][next.dest] = now.cost + next.cost;
                        pq.add(new Node(next.dest, dist[i][next.dest]));
                    }
                }
            }

            // System.out.println(Arrays.toString(dist[i]));
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < dist[0].length; i++){
            int sum = dist[0][i] + dist[1][i] + dist[2][i];
            if(min > sum){
                min = sum;
            }
        }
        
        return min;
    }
}