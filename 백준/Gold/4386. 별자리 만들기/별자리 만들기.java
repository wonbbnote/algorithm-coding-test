
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int to;
        double len;

        Node(int to, double len){
            this.to = to;
            this.len = len;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        double[][] arr = new double[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Double.parseDouble(st.nextToken());
            arr[i][1] = Double.parseDouble(st.nextToken());
        }

        ArrayList<Node>[] adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i != j){
                    double xlen = arr[i][0] - arr[j][0];
                    double ylen = arr[i][1] - arr[j][1];
                    double len = Math.sqrt(xlen * xlen + ylen * ylen);
                    adjList[i].add(new Node(j, len));
                }
            }
        }


        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> o.len));
        pq.add(new Node(0, 0));

        boolean[] visited = new boolean[N];

        double result = 0.0;

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            if(visited[curr.to]){
                continue;
            }

            visited[curr.to] = true;
            result += curr.len;

            for (Node next : adjList[curr.to]){
                if(!visited[next.to]){
                    pq.add(new Node(next.to, next.len));
                }
            }
        }

        String s = String.format("%.2f", result);
        System.out.println(s);


    }
}
