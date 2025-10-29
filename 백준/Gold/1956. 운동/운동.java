
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] arr = new int[V+1][V+1];
        int INF = 1_000_000_000;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if(i != j){
                    arr[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = c;
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if(i == j){
                        continue;
                    }

                    if(arr[i][j] > arr[i][k] + arr[k][j]){
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int res = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if(i == j){
                    continue;
                }

                if(arr[i][j] != INF && arr[j][i] != INF){
                    res = Math.min(res, arr[i][j] + arr[j][i]);
                }
            }
        }

        if(res == INF){
            System.out.println(-1);
        }else{
            System.out.println(res);
        }

    }
}
