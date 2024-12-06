import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        int dest, cost;

        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 도시의 개수
        int M = Integer.parseInt(br.readLine()); // 버스의 개수

        ArrayList<Node>[] adjList = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjList[start].add(new Node(dest, cost));
        }

        int[] dist = new int[N+1];
        int inf = Integer.MAX_VALUE;
        Arrays.fill(dist, inf);

        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        dist[a] = 0;
        pq.add(new Node(a, 0));

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            if(curr.cost > dist[curr.dest]){
                continue;
            }

            for(Node next: adjList[curr.dest]){
                if(dist[next.dest] > curr.cost + next.cost){
                    dist[next.dest] = curr.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }


        if(dist[b] != inf){
            System.out.println(dist[b]);
        }

    }
}
