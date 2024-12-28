import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] stairs = new int[N+1];
        for (int i = 1; i <= N; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int[] memo = new int[N+1]; // i번째까지 가기 위한 최댓값
        // (i-1번째까지 간 것 & i-2번째는 가지 않음 + i번째 점수)와 (i-2번째까지 간 것 & i-1번째 가지 않음 + i번째 점수) 중 최댓값
        int total = recur(stairs, memo, N);
        System.out.println(memo[N]);


    }

    public static int recur(int[] stairs, int[] memo, int i){
        if(i <= 0) return 0;
        if(i == 1) return memo[1] = stairs[1];
        if(memo[i] > 0) return memo[i];

        if(i >= 2){
            
            int case1 = recur(stairs, memo, i - 3) + stairs[i - 1] + stairs[i];
            int case2 = recur(stairs, memo, i - 2) + stairs[i];

            int max = Math.max(case1, case2);
            memo[i] = max;

        }
        return memo[i];


    }
}
