
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        // N 종류의 동전 중 K로 만드는 동전 개수의 최솟값

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer[] coins = new Integer[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins, Collections.reverseOrder());

        int count = 0;
        int value = 0;
        int idx = 0;
        while(value < K){
            if(coins[idx] > K){
                idx++;
            }else if(value + coins[idx] > K){
                idx++;
            }else{
                value += coins[idx];
                count++;
            }
        }

        System.out.println(count);
        
    }
}
