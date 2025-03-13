
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        System.out.println(bfs(N, M, arr));

    }

    static class Node{
        int x, y, wallBroken, dist;

        public Node(int x, int y, int wallBroken, int dist) {
            this.x = x;
            this.y = y;
            this.wallBroken = wallBroken;
            this.dist = dist;
        }
    }

    private static int bfs(int n, int m, char[][] arr) {
        boolean[][][] visited = new boolean[n][m][2];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0, 1));
        visited[0][0][0] = true;

        while(!queue.isEmpty()){
            Node curr = queue.poll();
            int curr_x = curr.x;
            int curr_y = curr.y;
            int curr_wallBroken = curr.wallBroken;
            int curr_dist = curr.dist;

            if(curr_x == n-1 && curr_y == m-1){
                return curr_dist;
            }

            for(int i = 0; i < 4; i++){
                int next_x = curr_x + dx[i];
                int next_y = curr_y + dy[i];

                if((next_x >= 0 && next_x < n) && (next_y >= 0 && next_y < m)){
                    // 벽이고 부술 수 있을 때
                    if(arr[next_x][next_y] == '1' && curr_wallBroken == 0 && !visited[next_x][next_y][1]){
                        visited[next_x][next_y][1] = true;
                        queue.add(new Node(next_x, next_y, 1, curr_dist + 1));
                    }

                    // 벽이 아닐 때
                    if(arr[next_x][next_y] == '0' && !visited[next_x][next_y][curr_wallBroken]){
                        visited[next_x][next_y][curr_wallBroken] = true;
                        queue.add(new Node(next_x, next_y, curr_wallBroken, curr_dist + 1));
                    }
                }
            }
        }
        return -1;
    }
}
