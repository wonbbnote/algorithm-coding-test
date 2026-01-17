
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1_000_000;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        int a = 1;
        int b = 26;

        int[] dp = new int[n+1];
        dp[n] = 1;

        for(int i = n - 1; i >= 0; i--){
            long num = 0;

            for (int j = i; j < n && j - i + 1 <= 2; j++) {
                if(s.charAt(i) == '0' && j > i) break;

                num = num * 10 + (s.charAt(j) - '0');
                if(num > b) break;
                if(num >= a) {
                    dp[i] += dp[j + 1];
                    if(dp[i] >= MOD) dp[i] %= MOD;
                }
            }
        }

        System.out.println(dp[0] % MOD);


    }
}

