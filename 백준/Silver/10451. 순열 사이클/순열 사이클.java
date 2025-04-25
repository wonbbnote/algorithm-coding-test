import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N + 1];
            for (int j = 1; j <= N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            boolean[] visited = new boolean[N + 1];
            Queue<Integer> queue = new ArrayDeque<>();
            int cycle = 0;
            
            for (int j = 1; j <= N; j++) {
                if (!visited[j]) {
                    queue.add(j);
                }else{
                    continue;
                }
                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    visited[curr] = true;

                    if (!visited[arr[curr]]) {
                        queue.add(arr[curr]);
                    }
                }
                cycle++;
            }
            System.out.println(cycle);
        }
    }
}
