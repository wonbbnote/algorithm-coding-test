
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int num1 = 0;
    static int num2 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        fib(N);
        int[] f = new int[N+1];
        fibByDp(N, f);
        System.out.println(num1 + " " + num2);
    }

    private static int fib(int n) {
        if(n == 1 || n == 2){
            num1++;
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    private static int fibByDp(int n, int[] f) {
        f[1] = 1;
        f[2] = 1;

        for (int i = 3; i <= n; i++) {
            f[n] = f[n-1] + f[n-2];
            num2++;
        }
        return f[n];
    }
}
