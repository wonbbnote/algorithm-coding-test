
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] line = new int[2];
            for (int j = 0; j < 2; j++) {
                line[j] = Integer.parseInt(st.nextToken());
            }
            pq.add(line);
        }

        int[][] sortedArr = new int[N][2];
        for (int i = 0; i < N; i++) {
            sortedArr[i] = pq.poll();
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        int max = 1;
        for (int i = 1; i < N; i++) {
            int loca = sortedArr[i][1];
            for (int j = 0; j < i; j++) {
                if(sortedArr[j][1] < loca){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);

        }
        System.out.println(N - max);
    }
}
