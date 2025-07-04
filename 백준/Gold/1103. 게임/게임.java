import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static boolean[][] visited;
    static boolean flag = false;
    static int[][] countMap;

    static int max = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        visited = new boolean[N][M];
        countMap = new int[N][M];
        visited[0][0] = true;
        countMap[0][0] = 1;
        dfs(0, 0, 1, arr);

        if(flag){
            System.out.println("-1");
        }else{
            System.out.println(max);
        }
    }

    private static void dfs(int x, int y, int count, char[][] arr){

        max = Math.max(max, count);
        countMap[x][y] = count;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i] * (arr[x][y] - '0');
            int ny = y + dy[i] * (arr[x][y] - '0');

            // 바깥이 아니고 구멍이 아닌 경우!
            if(isValid(nx, ny, arr) && arr[nx][ny] != 'H'){
                if(visited[nx][ny]){ // 이전에 이미 방문했다!
                    flag = true;
                    break;
                }else{ // 방문 한적 없다!
                    if(countMap[nx][ny] <= count){
                        visited[nx][ny] = true;
                        dfs(nx, ny, count + 1, arr);
                        visited[nx][ny] = false;
                    }
                }
            }
        }
    }

    private static boolean isValid(int nextX, int nextY, char[][] arr) {
        return (nextX >= 0 && nextX < arr.length) && (nextY >= 0 && nextY < arr[0].length);
    }
}
