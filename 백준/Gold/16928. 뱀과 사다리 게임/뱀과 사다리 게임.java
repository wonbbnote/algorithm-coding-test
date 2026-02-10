
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사다리 수
        int M = Integer.parseInt(st.nextToken()); // 뱀 수

        boolean[] arr = new boolean[101];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.put(x, y);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map.put(u, v);
        }

        int minDice = Integer.MAX_VALUE;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {1, 0});
        arr[1] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int loca = curr[0];
            int diceN = curr[1];

            if(diceN > minDice){
                continue;
            }

            if(loca == 100){
                minDice = Math.min(minDice, curr[1]);
            }

            if(map.containsKey(loca)){
                loca = map.get(loca);
            }

            for (int i = 1; i <= 6; i++) {
                int next = loca + i;
                if(next <= 100 && !arr[next]){
                    queue.add(new int[] {next, curr[1] + 1});
                    arr[next] = true;
                }
            }
        }

        System.out.println(minDice);

    }
}
