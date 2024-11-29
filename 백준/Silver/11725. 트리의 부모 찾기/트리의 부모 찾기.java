import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int[] answer;
    static ArrayList<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adjList[A].add(B);
            adjList[B].add(A);
        }

        visited = new boolean[N+1];
        answer = new int[N+1];
        DFS(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }

    }

    private static void DFS(int i) {
        visited[i] = true;
        for(int next: adjList[i]){
            if(!visited[next]){
                answer[next] = i;
                DFS(next);
            }
        }
    }
}
