import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이항계수1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[][] dp = new int[N+1][N+1];

        for(int i = 1; i <= N; i++){
            for (int j = 0; j <= N; j++) {
                if(j == 1) dp[i][j] = i;
                if(j == 0) dp[i][j] = 1;
                if(i == j) dp[i][j] = 1;

            }
        }

        for(int i = 2; i <= N; i++){
            for(int j = 1; j < i; j++){
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }
        System.out.println(dp[N][K]);
    }
}
