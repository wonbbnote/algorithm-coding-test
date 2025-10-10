
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int max;
    static int far;
    static class Node{
        int dest, weight;

        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        ArrayList<Node>[] arr = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int Vnum = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            while(next != -1){
                int dest = next;
                int weight = Integer.parseInt(st.nextToken());
                next = Integer.parseInt(st.nextToken());

                arr[Vnum].add(new Node(dest, weight));
            }
        }

        boolean[] visited = new boolean[V+1];
        dfs(1, 0, visited, arr);

        visited = new boolean[V+1];
        dfs(far, 0, visited, arr);

        System.out.println(max);

    }

    private static void dfs(int num, int length, boolean[] visited, ArrayList<Node>[] arr) {

        if(max < length){
            max = length;
            far = num;
        }
        visited[num] = true;

        for (Node node : arr[num]) {
            if(!visited[node.dest]){
                dfs(node.dest, length + node.weight, visited, arr);
            }
        }
    }
}
