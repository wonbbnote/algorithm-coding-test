import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 건물의 종류
        ArrayList<Integer>[] adjList = new ArrayList[N+1]; // 인접 리스트
        int[] arr = new int[N+1]; // 위상 정렬을 위한 진입차수 배열
        int[] cost_arr = new int[N+1]; // 각 건물을 지을 때 필요한 cost
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            cost_arr[i] = Integer.parseInt(st.nextToken());

            while(true){
                int next = Integer.parseInt(st.nextToken());
                if (next == -1) break;
                arr[i]++;
                adjList[next].add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N ; i++) {
            if(arr[i] == 0){
                q.add(i);
            }
        }

        int[] result = new int[N+1];
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int next: adjList[curr]){
                arr[next]--;
                result[next] = Math.max(result[next], result[curr] + cost_arr[curr]);
                if(arr[next] == 0){
                    q.add(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(result[i] + cost_arr[i]);
        }






    }
}
