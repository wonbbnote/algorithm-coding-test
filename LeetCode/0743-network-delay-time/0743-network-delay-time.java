import java.util.*;

class Solution {

    private static class Node{
        int dest, cost;
        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Node>[] adjList = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int[] time: times){
            adjList[time[0]].add(new Node(time[1], time[2]));
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;
        int visitCount = 1;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(k, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.dest] < now.cost){
                continue;
            }

            for(Node next: adjList[now.dest]){
                if(dist[next.dest] > now.cost + next.cost){
                    if (dist[next.dest] == Integer.MAX_VALUE) visitCount++;
                    dist[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        if(visitCount < n){
            return -1;
        }

        int max = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] > max){
                max = dist[i];
            }
        }

        return max;

        




        


        
    }
}