
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 버틸수 있는 무게

        int[][] arr = new int[N + 1][2]; // 각 물건의 무게, 가치
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) { // 물건 별
            for (int k = 1; k <= K; k++) { // 무게별
                dp[i][k] = dp[i-1][k];
                if(k >= arr[i][0]){
                    dp[i][k] = Math.max(dp[i][k], dp[i-1][k - arr[i][0]] + arr[i][1]);
                }
            }
        }

        System.out.println(dp[N][K]);

    }
}
