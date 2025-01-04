import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
//            System.out.println(Arrays.toString(arr[i]));
        }

        boolean[][] visited = new boolean[N][M];
        int[][] map = new int[N][M];
        visited[0][0] = true;
        map[0][0] = 1;

        bfs(0,0, visited, arr, map);
        System.out.println(map[N-1][M-1]);
        
    }

    private static void bfs(int a, int b, boolean[][] visited, char[][] arr, int[][] map) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {a, b});

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int next_r = curr[0] + dx[i];
                int next_c = curr[1] + dy[i];

                if(next_r < 0 || next_c < 0 || next_r >= N || next_c >= M || arr[next_r][next_c] == '0' || visited[next_r][next_c]){
                    continue;
                }

                visited[next_r][next_c] = true;
                queue.add(new int[] {next_r, next_c});
                map[next_r][next_c] = map[curr[0]][curr[1]] + 1;
            }
        }

    }
}
