
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[] dx = {-1, -2, 1, 2, -2, -1, 2, 1};
    public static int[] dy = {2, 1, 2, 1, -1, -2, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int I = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int lastX = Integer.parseInt(st.nextToken());
            int lastY = Integer.parseInt(st.nextToken());

            boolean[][] visited = new boolean[I][I];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {startX, startY, 0});
            visited[startX][startY] = true;

            while(!queue.isEmpty()){
                int[] curr = queue.poll();

                if(curr[0] == lastX && curr[1] == lastY){
                    System.out.println(curr[2]);
                    break;
                }

                for (int j = 0; j < 8; j++) {
                    int nextX = curr[0] + dx[j];
                    int nextY = curr[1] + dy[j];

                    if(nextX >= 0 && nextX < I && nextY >= 0 && nextY < I){
                        if(!visited[nextX][nextY]){
                            visited[nextX][nextY] = true;
                            queue.add(new int[]{nextX, nextY, curr[2] + 1});
                        }
                    }
                }
            }
        }
    }
}
