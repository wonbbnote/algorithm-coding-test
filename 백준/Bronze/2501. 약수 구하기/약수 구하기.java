
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean state = false;
        int nth = 0;
        for (int i = 1; i <= N; i++) {
            if(N % i == 0){
                nth++;
                if(nth == K){
                    System.out.println(i);
                    state = true;
                    break;
                }
            }
        }

        if(!state){
            System.out.println(0);
        }
    }
}
