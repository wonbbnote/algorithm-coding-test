
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] adjList = new ArrayList[N+1];
        for (int i = 1; i <= N ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            adjList[start].add(new Node(end, t));
        }


        // X -> 각 집
        int[] result = new int[N+1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[X] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(X, 0));

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            if(result[curr.dest] < curr.cost){
                continue;
            }

            for(Node next : adjList[curr.dest]){
                if(result[next.dest] > curr.cost + next.cost){
                    result[next.dest] = curr.cost + next.cost;
                    pq.add(new Node(next.dest, result[next.dest]));
                }
            }
        }
        
        // 각 집 -> X
        for (int i = 1; i <= N; i++) {

            if(i == X){
                continue;
            }

            int[] visited = new int[N+1];
            Arrays.fill(visited, Integer.MAX_VALUE);
            visited[i] = 0;

            pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
            pq.add(new Node(i, 0));

            while(!pq.isEmpty()){
                Node curr = pq.poll();

                if(visited[curr.dest] < curr.cost){
                    continue;
                }

                for(Node next : adjList[curr.dest]){
                    if(visited[next.dest] > curr.cost + next.cost){
                        visited[next.dest] = curr.cost + next.cost;
                        pq.add(new Node(next.dest, visited[next.dest]));
                    }
                }
            }

            result[i] += visited[X];

        }


        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, result[i]);
        }

        System.out.println(max);

    }
}
