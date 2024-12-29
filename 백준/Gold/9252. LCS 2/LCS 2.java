import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] text1 = br.readLine().toCharArray();
        char[] text2 = br.readLine().toCharArray();

        int[][] dp = new int[text1.length+1][text2.length+1];

        // 길이구하기
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

        int result = dp[text1.length][text2.length];
        System.out.println(result);

        // 문자열 구하기
        int m = text1.length;
        int n = text2.length;

        String resStr = "";
        if(result > 0){
            Stack<Character> stack = new Stack<>();

            while(m > 0 && n > 0){

                if(dp[m][n] == dp[m-1][n]){
                    m--;
                }else if(dp[m][n] == dp[m][n-1]){
                    n--;
                }else{
                    stack.push(text1[m - 1]);
                    m--;
                    n--;
                }
            }

            while(!stack.isEmpty()){
                resStr += stack.pop();
            }
            System.out.println(resStr);
        }




    }
}
