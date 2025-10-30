
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] arr;
    static int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N+1][10];
        for (int i = 1; i <= 9; i++) {
            arr[1][i] = 1;
        }

        for (int num = 2; num <= N ; num++) {
            for (int i = 0; i < 10; i++) {
                if(i == 0){
                    arr[num][i] = arr[num-1][i+1] % MOD;
                }else if(i == 9){
                    arr[num][i] = arr[num-1][i-1] % MOD;;
                }else{
                    arr[num][i] = (arr[num-1][i-1] + arr[num-1][i+1]) % MOD;;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 10; i++) {
            res += arr[N][i];
            res %= 1_000_000_000;
        }

        System.out.println(res);

    }
}
