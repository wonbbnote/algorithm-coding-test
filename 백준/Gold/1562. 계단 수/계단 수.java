import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(countStairNumbers(n));
    }

    public static int countStairNumbers(int n) {
        // dp[i][j][used]: i자리, 마지막 숫자가 j이고, used 상태의 계단 수 개수
        long[][][] dp = new long[n + 1][10][1 << 10];

        // 초기값 설정 - 한 자리 숫자의 경우
        for (int i = 1; i < 10; i++) {  // 0으로 시작하는 수는 제외
            dp[1][i][1<<i] = 1;  // 각 숫자의 사용 여부를 비트마스크로 표시
        }

        // n자리 숫자에 대해 계산
        for (int length = 1; length < n; length++) {
            for (int last = 0; last < 10; last++) {
                for (int used = 0; used < (1 << 10); used++) {
                    if (dp[length][last][used] == 0) {
                        continue;
                    }

                    // 이전 숫자보다 1 큰 경우
                    if (last < 9) {
                        int nextUsed = used | (1 << (last + 1));
                        dp[length + 1][last + 1][nextUsed] = (dp[length + 1][last + 1][nextUsed] + dp[length][last][used]) % MOD;
                            
                    }

                    // 이전 숫자보다 1 작은 경우
                    if (last > 0) {
                        int nextUsed = used | (1 << (last - 1));
                        dp[length + 1][last - 1][nextUsed] = (dp[length + 1][last - 1][nextUsed] + dp[length][last][used]) % MOD;
                            
                    }
                }
            }
        }

        // 모든 숫자를 사용한 경우의 답 계산
        int answer = 0;
        int allUsed = (1 << 10) - 1;  // 모든 숫자가 사용된 상태

        for (int last = 0; last < 10; last++) {
            answer = (int)((answer + dp[n][last][allUsed]) % MOD);
        }

        return answer;
    }
}