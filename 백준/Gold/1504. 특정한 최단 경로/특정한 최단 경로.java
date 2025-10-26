import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int dest, cost;

        Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }

    static int N, E;
    static ArrayList<Node>[] adjList;
    static int INF = 200_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[a].add(new Node(b, c));
            adjList[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int r1 = 0;
        r1 += dijkstra(1, v1);
        r1 += dijkstra(v1, v2);
        r1 += dijkstra(v2, N);

        int r2 = 0;
        r2 += dijkstra(1, v2);
        r2 += dijkstra(v2, v1);
        r2 += dijkstra(v1, N);

        int result = (r1 >= INF && r2 >= INF) ? -1 : Math.min(r1, r2);
        System.out.println(result);

    }

    public static int dijkstra(int s, int e){

        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[s] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(s, 0));

        while(!pq.isEmpty()){

            Node curr = pq.poll();

            if(dist[curr.dest] < curr.cost){
                continue;
            }

            for (Node next :adjList[curr.dest]){
                if(dist[next.dest] > dist[curr.dest] + next.cost){
                    dist[next.dest] = dist[curr.dest] + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        return dist[e];

    }
}
