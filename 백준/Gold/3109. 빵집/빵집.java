
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        System.out.println(installPipes(R, C, arr));
    }

    private static int installPipes(int R, int C, char[][] arr) {
        int totalPipelines = 0;

        for (int i = 0; i < R; i++) {
            if(arr[i][0] == '.'){
                if(dfs(i, 0, R, C, arr)){
                    totalPipelines++;
                }
            }
        }
        return totalPipelines;
    }

    private static boolean dfs(int row, int col, int R, int C, char[][] arr) {

        if(col == C-1){
            return true;
        }

        for (int dx: new int[] {-1, 0, 1}) {
            int next_x = row + dx;
            int next_y = col + 1;

            if(next_x < R && next_x >= 0 && arr[next_x][next_y] == '.'){
                arr[next_x][next_y] = 'x';
                if(dfs(next_x, next_y, R, C, arr)){
                    return true;
                }
            }
        }

        return false;
    }


}
