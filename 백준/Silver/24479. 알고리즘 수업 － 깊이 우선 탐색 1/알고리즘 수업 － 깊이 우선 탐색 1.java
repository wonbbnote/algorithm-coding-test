
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<Integer, Integer> res;
    static int order = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u].add(v);
            arr[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(arr[i]);
        }

        boolean[] visited = new boolean[N+1];
        res = new HashMap<>();
        res.put(R, order++);

        dfs(R, visited, arr);

        for (int i = 1; i <= N ; i++) {
            if(!res.containsKey(i)){
                System.out.println(0);
            }else{
                System.out.println(res.get(i));
            }
        }

    }

    private static void dfs(int r, boolean[] visited, ArrayList<Integer>[] arr) {
        visited[r] = true;

        for(int next: arr[r]){
            if(!visited[next]){
                res.put(next, order++);
                dfs(next, visited, arr);
            }
        }
    }
}
