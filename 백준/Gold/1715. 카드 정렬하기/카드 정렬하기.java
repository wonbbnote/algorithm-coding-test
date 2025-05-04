
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a: arr){
            pq.add(a);
        }

        int answer = 0;
        while(pq.size() > 1){
            int g1 = pq.poll();
            int g2 = pq.poll();
            int sum = g1 + g2;
            answer += sum;
            pq.add(sum);
        }
        
        System.out.println(answer);
    }
}
