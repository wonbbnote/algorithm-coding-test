
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            Queue<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int j = 0; j < N; j++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new int[] {j, priority});
                pq.add(priority);
            }

            int order = 0;
            Integer maxPriority = pq.poll();

            while(!queue.isEmpty()){
                int[] polled = queue.poll();

                if(maxPriority > polled[1]){
                    queue.add(polled);
                }else{
                    order++;
                    maxPriority = pq.poll();
                    if(polled[0] == M){
                        System.out.println(order);
                        break;
                    }
                }
            }
        }
    }
}
