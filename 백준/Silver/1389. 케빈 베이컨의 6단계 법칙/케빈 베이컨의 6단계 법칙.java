import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 유저의 수
        int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수

        int[][] relations = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relations[a][b] = 1;
            relations[b][a] = 1;
        }


        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(relations[i][k] > 0 && relations[k][j] > 0){

                        if(relations[i][j] == 0){
                            relations[i][j] = relations[i][k] + relations[k][j];
                        }else{
                            relations[i][j] = Math.min(relations[i][j], relations[i][k] + relations[k][j]);
                        }

                    }
                }
            }
        }

        int[] min = new int[N+1];
        int minVal = Integer.MAX_VALUE;
        for (int i = 1; i <= N ; i++) {
            int sum = 0;
            for (int j = 1; j <= N ; j++) {

                if(i != j){
                    sum += relations[i][j];
                }
            }
            if(minVal > sum){
                minVal = sum;
            }
            min[i] = sum;
        }

        for (int i = 1; i <= N ; i++) {
            if(min[i] == minVal) {
                System.out.println(i);
                break;
            }
        }






    }
}
