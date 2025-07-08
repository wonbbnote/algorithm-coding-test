
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long sum = pow(A, B, C) % C;
        System.out.println(sum);
    }

    public static long pow(int a, int b, int c){
        if(b == 1){
            return a % c;
        }

        long result = pow(a, b/2, c);
        if(b % 2 == 0){
            return result * result % c;
        }
        return ((result * result) % c) * a % c;
    }
}