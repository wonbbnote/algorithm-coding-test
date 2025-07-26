
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int order = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u - 1).add(v);
            graph.get(v - 1).add(u);
        }

        for (int i = 0; i < N; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }
        
        
        boolean[] visited = new boolean[N];
        int[] res = new int[N];

        visited[R - 1] = true;
        res[R-1] = order++;

        dfs(R, visited, graph, res);

        for (int num: res) {
            System.out.println(num);
        }

    }

    private static void dfs(int r, boolean[] visited, List<List<Integer>> graph, int[] res) {
        visited[r - 1] = true;

        for (int next : graph.get(r-1)) {
            if(!visited[next-1]){
                res[next-1] = order++;
                dfs(next, visited, graph, res);
            }
        }
    }
}
