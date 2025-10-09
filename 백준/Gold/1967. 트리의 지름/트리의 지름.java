
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int dest, weight;

        public Node(int dest, int weight){
            this.dest = dest;
            this.weight = weight;
        }
    }

    static ArrayList<Node>[] arr;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new ArrayList[N+1];
        for (int i = 1; i <= N ; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            arr[parent].add(new Node(child, weight));
            arr[child].add(new Node(parent, weight));
        }


        for (int i = 1; i <= N ; i++) {
            boolean[] visited = new boolean[N+1];
            visited[i] = true;
            dfs(i, visited, 0);
        }

        System.out.println(max);


    }

    private static void dfs(int i, boolean[] visited, int w) {

        max = Math.max(w, max);

        for (Node node: arr[i]) {
            if(!visited[node.dest]){
                visited[node.dest] = true;
                dfs(node.dest, visited, w+node.weight);
            }
        }
    }
}
