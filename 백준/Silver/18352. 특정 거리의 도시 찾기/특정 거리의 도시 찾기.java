import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int K = scan.nextInt();
        int X = scan.nextInt();

        ArrayList<Integer>[] A = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int S = scan.nextInt();
            int E = scan.nextInt();
            A[S].add(E);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);
        int[] visited = new int[N+1];
        Arrays.fill(visited, -1);
        visited[X] = 0;

        List<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < A[now].size(); i++) {
                int next = A[now].get(i);
                if (visited[next] == -1) {
                    visited[next] = visited[now] + 1;
                    queue.add(next);
                }
            }
        }

        for (int i = 1; i < visited.length; i++){
            if(visited[i] == K){
                answer.add(i);
            }
        }

        if(answer.size() == 0){
            System.out.println("-1");

        }else {
            Collections.sort(answer);
            for (int t: answer) {
                System.out.println(t);
            }
        }













    }
}
