import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int min = 1_000_000_000;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        account(A, B, 0);

        if(min == 1_000_000_000){
            System.out.println(-1);
        }else{
            System.out.println(min + 1);
        }
    }

    private static void account(long a, long b, int i) {
        if(a == b) {
            min = Math.min(min, i);
            return;
        }else if(a > b){
            return;
        }
        
        account(a * 2, b, i + 1);
        account(Long.parseLong(a + "1"), b, i + 1);
    }
}
