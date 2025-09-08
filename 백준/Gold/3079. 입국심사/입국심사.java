import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        // 사람 M명, 입국 심사대 N개
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        
        
        long left = 0;
        long right = arr[arr.length - 1] * M;

        while(left < right){
            long mid = (left + right) / 2;

            long possibleM = 0;
            for(int time: arr){
                long cnt = mid / time;
                if(possibleM >= M){
                    break;
                }
                possibleM += cnt;
            }

            if(possibleM >= M){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        System.out.println(left);

    }
}
