
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int dest, len;
        Node(int dest, int len){
            this.dest = dest;
            this.len = len;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] itemNum = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            itemNum[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Node>[] adjList = new ArrayList[n+1];

        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            adjList[from].add(new Node(to, len));
            adjList[to].add(new Node(from, len));
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {

            int[] dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.len - o2.len);
            pq.add(new Node(i, 0));

            while(!pq.isEmpty()){
                Node curr = pq.poll();

                if(dist[curr.dest] < curr.len){
                    continue;
                }

                for(Node next: adjList[curr.dest]){
                    if(dist[next.dest] > next.len + curr.len){
                        dist[next.dest] = next.len + curr.len;
                        pq.add(new Node(next.dest, dist[next.dest]));
                    }
                }
            }

            int getItem = 0;
            for (int j = 1; j <= n; j++) {
                if(dist[j] <= m){
                    getItem += itemNum[j];
                }
            }

            max = Math.max(max, getItem);

        }
        System.out.println(max);


    }
}
