
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new ArrayDeque<>();

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    queue.add(new int[] {i, j, 0});
                }
            }
        }

        int day = 0;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            day = curr[2];

            for (int i = 0; i < 4; i++) {
                int nextX = curr[0] + dx[i];
                int nextY = curr[1] + dy[i];

                if(isValid(nextX, nextY, N, M) && arr[nextX][nextY] == 0){
                    arr[nextX][nextY] = 1;
                    queue.add(new int[] {nextX, nextY, curr[2]+1});
                }
            }
        }

        boolean allRiped = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0){
                    allRiped = false;
                    break;
                }
            }
        }

        if(allRiped){
            System.out.println(day);
        }else{
            System.out.println(-1);
        }
    }

    private static boolean isValid(int nextX, int nextY, int n, int m) {
        return (nextX >= 0 && nextX < n) && (nextY >= 0 && nextY < m);
    }
}
