import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        int max = 0;
        for (int i = 0; i < K ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long left = 1;
        long right = (long) max + 1;

        while(left < right){
            long mid = ( left + right ) / 2; // 랜선의 길이

            long possible = 0;
            for (int i = 0; i < K; i++) {
                possible += arr[i] / mid;
            }

            if(possible < N){ // 랜선의 길이가 더 작아야 함
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        System.out.println(left - 1);

    }
}
