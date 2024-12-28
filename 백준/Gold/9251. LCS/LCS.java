import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] text1 = br.readLine().toCharArray();
        char[] text2 = br.readLine().toCharArray();

        int[][] dp = new int[text1.length+1][text2.length+1];
        for (int i = 1; i <= text1.length; i++) {
            char c1 = text1[i-1];
            for (int j = 1; j <= text2.length; j++) {
                char c2 = text2[j-1];

                if(c1 == c2){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
            
        }

        System.out.println(dp[text1.length][text2.length]);
        
    }
}
