
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        List<int[]> chicken = new ArrayList<>();
        List<int[]> people = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 1){
                    people.add(new int[]{i, j});
                }else if(arr[i][j] == 2){
                    chicken.add(new int[]{i, j});
                }
            }
        }

        answer = Integer.MAX_VALUE;
        boolean[] open = new boolean[chicken.size()];
        backtracking(0, 0, M, open, chicken, people);
        System.out.println(answer);
    }

    public static void backtracking(int start, int cnt, int M, boolean[] open, List<int[]> chicken, List<int[]> people){

        if(cnt == M){
            int total = 0;
            for (int i = 0; i < people.size(); i++) {
                int[] person = people.get(i);
                int temp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if(open[j]){
                        int dist = Math.abs(person[0] - chicken.get(j)[0]) + Math.abs(person[1] - chicken.get(j)[1]);
                        temp = Math.min(temp, dist);
                    }
                }
                total += temp;
            }
            answer = Math.min(total, answer);
            return;
        }


        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            backtracking(i+1, cnt+1, M, open, chicken, people);
            open[i] = false;
        }
    }
}
