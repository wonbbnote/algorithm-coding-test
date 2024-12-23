import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        int[] front = new int[N];
        Arrays.fill(front, -1);

        int max = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    front[i] = j;
                }
            }
            max = Math.max(max, dp[i]);
        }

        int maxIdx = 0;
        for (int i = N-1; i >= 0; i--) {
            if(dp[i] == max){
                maxIdx = i;
                break;
            }
        }

        int idx = maxIdx;
        int[] finalRes = new int[max];
        for (int i = max-1; i >= 0; i--) {
            finalRes[i] = arr[idx];
            idx = front[idx];
        }

        System.out.println(max);
        for (int num: finalRes) {
            System.out.print(num +" ");
        }


    }
}
