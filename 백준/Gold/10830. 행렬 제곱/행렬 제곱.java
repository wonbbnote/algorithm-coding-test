
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Long B = Long.parseLong(st.nextToken());

        // 분할 정복으로 풀어야 한다!?

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] result = pow(arr, B);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] pow(int[][] arr, long b){

        if(b == 1L){
            return arr;
        }

        int[][] temp = pow(arr, b / 2);

        temp = multiply(arr.length, temp, temp);

        if(b % 2 == 1L){
            temp = multiply(arr.length, temp, arr);
        }

        return temp;
    }

    public static int[][] multiply(int N, int[][] o1, int[][] o2){

        int[][] res = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    res[i][j] += o1[i][k] * o2[k][j];
                    res[i][j] %= 1000;
                }
            }
        }
        return res;
    }
}
