import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adjList = new ArrayList[N+1];
        int[] arr = new int[N+1];
        for (int i = 1; i <= N ; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adjList[A].add(B);
            arr[B]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == 0){
                queue.add(i);
                visited[i] = true;
            }
        }

        while(!queue.isEmpty()){
            int curr = queue.poll();
            System.out.print(curr + " ");

            for(int next: adjList[curr]){
                arr[next]--;
            }

            for (int i = 1; i <= N; i++) {
                if(!visited[i] && arr[i] == 0){
                    queue.add(i);
                    visited[i] = true;
                }
            }

        }









    }
}
