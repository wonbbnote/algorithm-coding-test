
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    
    static int maxNum;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            String n = new StringTokenizer(br.readLine()).nextToken();
            for (int j = 0; j < C; j++) {
                arr[i][j] = n.charAt(j);
            }
        }

        boolean[][] visited = new boolean[R][C];
        visited[0][0] = true;
        Set<Character> set = new HashSet<>();
        set.add(arr[0][0]);
        tracking(R, C,0, 0, visited, set, arr);

        System.out.println(maxNum);
    }

    public static void tracking(int r, int c, int x, int y, boolean[][] visited, Set<Character> set, char[][] arr){

        maxNum = Math.max(maxNum, set.size());

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 0 && nextX < r && nextY >= 0 && nextY < c){
                if(!visited[nextX][nextY]){
                    if(!set.contains(arr[nextX][nextY])){
                        visited[nextX][nextY] = true;
                        set.add(arr[nextX][nextY]);
                        tracking(r, c, nextX, nextY, visited, set, arr);
                        visited[nextX][nextY] = false;
                        set.remove(arr[nextX][nextY]);
                    }
                }
            }
        }
    }
}
