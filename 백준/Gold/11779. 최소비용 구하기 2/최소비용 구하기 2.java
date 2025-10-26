
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Node>[] adjList = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList[from].add(new Node(to, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        int[] process = new int[N+1];

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            if(dist[curr.dest] < curr.cost){
                continue;
            }

            for (Node next: adjList[curr.dest]){
                if(dist[next.dest] > dist[curr.dest] + next.cost){
                    dist[next.dest] = dist[curr.dest] + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                    process[next.dest] = curr.dest;
                }
            }
        }

        System.out.println(dist[end]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int count = 1;
        stack.push(end);
        while(process[end] != 0){
            stack.push(process[end]);
            end = process[end];
            count++;
        }

        System.out.println(count);

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
