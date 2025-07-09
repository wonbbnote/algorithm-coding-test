
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[100_001];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.add(new int[] {N, 0});
        check[N] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int loca = curr[0];
            int time = curr[1];
            check[loca] = true;

            if(loca == K){
                System.out.println(time);
                break;
            }

            if(loca * 2 < 100_001 && !check[loca * 2]){
                queue.add(new int[] {loca * 2, time});
            }

            if(loca + 1 >= 0 && loca + 1 < 100_001 && !check[loca + 1]){
                queue.add(new int[] {loca + 1, time + 1});
            }

            if(loca - 1 >= 0 && loca - 1 < 100_001 && !check[loca - 1]){
                queue.add(new int[] {loca - 1, time + 1});
            }
        }
    }
}
