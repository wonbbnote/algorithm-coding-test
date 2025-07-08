
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], -1);
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i; j++) {
                arr[i - 1][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0){
                    arr[i][j] += arr[i - 1][j];
                }else if(j == i){
                    arr[i][j] += arr[i - 1][j - 1];
                }else{
                    arr[i][j] = Math.max(arr[i][j] + arr[i-1][j-1], arr[i][j] + arr[i-1][j]);
                }
            }
        }

        int max = -1;
        for (int i = 0; i < N; i++) {
            max = Math.max(arr[N-1][i], max);
        }
        System.out.println(max);
    }
}
