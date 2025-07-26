
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 0, 1, 0, -1};
    static int[] dz = {-1, 1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] arr = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(arr[i][j][k] == 1){
                        queue.add(new int[] {i, j, k, 0});
                    }
                }
            }
        }

        int day = 0;
        while(!queue.isEmpty()){
            int[] polled = queue.poll();
            day = polled[3];

            for (int i = 0; i < 6; i++) {
                int nextZ = polled[0] + dz[i];
                int nextY = polled[1] + dy[i];
                int nextX = polled[2] + dx[i];

                if(isValid(nextX, nextY, nextZ, M, N, H) && arr[nextZ][nextY][nextX] == 0){
                    arr[nextZ][nextY][nextX] = 1;
                    queue.add(new int[] {nextZ, nextY, nextX, polled[3] + 1});
                }
            }
        }

        boolean allRiped = true;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(arr[i][j][k] == 0){
                        allRiped = false;
                        break;
                    }
                }
            }
        }

        if(allRiped){
            System.out.println(day);
        }else{
            System.out.println(-1);
        }
    }

    private static boolean isValid(int nextX, int nextY, int nextZ, int M, int N, int H) {
        return (nextX >= 0 && nextX < M) && (nextY >= 0 && nextY < N) && (nextZ >= 0 && nextZ < H);
    }
}
