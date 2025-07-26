
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] graph = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        int count = 0;

        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new ArrayDeque<>();

        visited[1] = true;
        queue.add(1);

        while(!queue.isEmpty()){
            int curr = queue.poll();

            for (int next: graph[curr]) {
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        
        System.out.println(count);
    }
}
