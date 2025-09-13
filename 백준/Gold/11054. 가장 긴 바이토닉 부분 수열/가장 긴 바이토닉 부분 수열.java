
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] lisDp = new int[N];
        Arrays.fill(lisDp, 1);
        int[] ldsDp = new int[N];
        Arrays.fill(ldsDp, 1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]){
                    lisDp[i] = Math.max(lisDp[i], lisDp[j] + 1);
                }
            }
        }

        for (int i = N-1; i >= 0; i--) {
            for (int j = N-1; j > i; j--) {
                if(arr[j] < arr[i]){
                    ldsDp[i] = Math.max(ldsDp[i], ldsDp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N ; i++) {
            max = Math.max(max, lisDp[i] + ldsDp[i]);
        }
        System.out.println(max - 1);


    }
}
