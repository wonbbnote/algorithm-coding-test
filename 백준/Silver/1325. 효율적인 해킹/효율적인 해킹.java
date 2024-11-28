import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] Adj;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();

        Adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            Adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int A = scan.nextInt();
            int B = scan.nextInt();
            Adj[B].add(A);
        }


        int maxNum = -1;
        int[] answer = new int[N+1];

        for(int i = 1; i <= N; i++){
            visited = new boolean[N+1];
            List<Integer> ans = new ArrayList<>();
            DFS(i, ans);
            answer[i] = ans.size();
            maxNum = Math.max(maxNum, ans.size());
        }

        for (int i = 1; i < answer.length; i++) {
            if(answer[i] == maxNum){
                System.out.print(i + " ");
            }
        }

    }


    private static void DFS(int i, List<Integer> ans) {
        visited[i] = true;
        ans.add(i);
        for(int next : Adj[i]){
            if(!visited[next]){
                DFS(next, ans);
            }
        }
    }
}
