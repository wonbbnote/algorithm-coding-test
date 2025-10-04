
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] arr = new int[M][N];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr[x][y] = 1;
            }

            int[][] visited = new int[M][N];
            int num = 0;
            for (int m = 0; m < M; m++) {
                for (int n = 0; n < N; n++) {

                    if(arr[m][n] == 1 && visited[m][n] == 0){
                        num++;
                        dfs(m, n, visited, arr, num);

                    }
                }
            }

            System.out.println(num);

        }
    }

    public static void dfs(int x, int y, int[][] visited, int[][] arr, int num){

        visited[x][y] = num;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 0 && nextX < arr.length && nextY >= 0 && nextY < arr[0].length){
                if(arr[nextX][nextY] == 1 && visited[nextX][nextY] == 0){
                    dfs(nextX, nextY, visited, arr, num);
                }
            }
        }
    }
}
