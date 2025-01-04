import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            adjList[to].add(from);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList[i]);
        }


        //DFS
        visited = new boolean[N+1];
        List<Integer> dfs = new ArrayList<>();
        dfs(V, dfs);

        for(int num: dfs){
            System.out.print(num + " ");
        }

        System.out.println();

        // BFS
        visited = new boolean[N+1];
        List<Integer> bfs = new ArrayList<>();
        bfs(V, bfs);
//        System.out.println(bfs);
        for(int num: bfs){
            System.out.print(num + " ");
        }




    }

    private static void dfs(int v, List<Integer> res) {
        visited[v] = true;
        res.add(v);

        for(int next: adjList[v]){
            if(!visited[next]){
                dfs(next, res);
            }
        }



    }

    private static void bfs(int v, List<Integer> res) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            res.add(now);

            for(int next: adjList[now]){
                if(!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                }
            }

        }
    }
}
