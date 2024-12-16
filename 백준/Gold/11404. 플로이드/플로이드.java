import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 도시의 개수
        int M = Integer.parseInt(br.readLine()); // 버스의 개수

        // 2차원 배열
        int[][] arr = new int[N+1][N+1];
        int inf = 100_000_000;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N ; j++) {
                if(i == j) {
                    arr[i][j] = 0;
                }else{
                    arr[i][j] = inf;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if(arr[a][b] > cost) arr[a][b] = cost;
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N ; j++) {
                if(arr[i][j] == inf){
                    System.out.print(0 + " ");
                }else{
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();

        }
    }
}
