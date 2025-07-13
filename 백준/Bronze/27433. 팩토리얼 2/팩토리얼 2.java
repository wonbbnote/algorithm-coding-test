import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long result = factorial(N);
        System.out.println(result);

    }

    public static long factorial(int N){
        if(N == 1 || N == 0){
            return 1;
        }
        return N * factorial(N-1);
    }
}
