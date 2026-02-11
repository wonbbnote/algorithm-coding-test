
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] arr = new char[N][N];
        boolean[][] boolArr = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int n = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!boolArr[i][j]){
                    bfs(arr[i][j], i, j, arr, boolArr);
                    n++;
                }
            }
        }
        System.out.print(n + " ");

        char[][] arr2 = new char[N][N];
        boolean[][] boolArr2 = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == 'G' || arr[i][j] == 'R'){
                    arr2[i][j] = 'A';
                }
            }
        }

        int n2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!boolArr2[i][j]){
                    bfs(arr2[i][j], i, j, arr2, boolArr2);
                    n2++;
                }
            }
        }
        System.out.println(n2);
        
    }

    private static void bfs(char col, int i, int j, char[][] arr, boolean[][] boolArr) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        boolArr[i][j] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nextX = curr[0] + dx[k];
                int nextY = curr[1] + dy[k];

                if(nextX >= 0 && nextX < arr.length && nextY >= 0 && nextY < arr[0].length){
                    if(arr[nextX][nextY] == col && !boolArr[nextX][nextY]){
                        boolArr[nextX][nextY] = true;
                        queue.add(new int[] {nextX, nextY});
                    }
                }
            }
        }
    }
}
