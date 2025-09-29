
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        int num = 10;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == 1){
                    count = 0;
                    dfs(i, j, arr, num);
                    num++;
                    res.add(count);
                }
            }
        }

        System.out.println(res.size());
        Collections.sort(res);
        for(int n: res){
            System.out.println(n);
        }

    }

    public static void dfs(int x, int y, int[][] arr, int num){

        arr[x][y] = num;
        count++;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 0 && nextX < arr.length && nextY >= 0 && nextY < arr[0].length && arr[nextX][nextY] == 1){
                dfs(nextX, nextY, arr, num);
            }
        }

    }
}
