
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int final_count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, arr, S, 0);
        if(S == 0){
            final_count--;
        }
        System.out.println(final_count);



    }
    public static void backtracking(int start, int[] arr, int S, int sum){

        if(sum == S){
            final_count++;
        }

        for (int i = start; i < arr.length; i++) {
            sum += arr[i];
            backtracking(i + 1, arr, S, sum);
            sum -= arr[i];
        }

    }
}
