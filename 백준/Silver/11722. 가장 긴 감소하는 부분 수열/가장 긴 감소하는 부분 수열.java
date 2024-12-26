import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dp = new int[N]; // i번째 수가 가진 감소하는 부분수열
        Arrays.fill(dp, 1);

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        int res = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    res = Math.max(res, dp[i]);
                }
            }
        }

        System.out.println(res);
    }
}
