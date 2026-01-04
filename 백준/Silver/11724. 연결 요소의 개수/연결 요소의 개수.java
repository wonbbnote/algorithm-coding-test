
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);
        }

        boolean[] visited = new boolean[N+1];
        int num = 0;
        for (int i = 1; i <= N; i++) {
            if(!visited[i]){
                dfs(visited, i);
                num++;
            }
        }

        System.out.println(num);
        
    }

    public static void dfs(boolean[] visited, int n){

        visited[n] = true;

        for(int next : adjList[n]){
            if(!visited[next]){
                dfs(visited, next);
            }
        }

    }
}
