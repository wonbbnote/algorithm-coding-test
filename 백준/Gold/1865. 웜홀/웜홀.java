
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static class Edge{
        int from, to, time;

        Edge(int from, int to, int time){
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }

    static ArrayList<Edge> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int i = 1; i <= TC; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 지점 수
            int M = Integer.parseInt(st.nextToken()); // 도로 개수
            int W = Integer.parseInt(st.nextToken()); // 웜홀 개수

            list = new ArrayList<>();

            // 도로
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                list.add(new Edge(S, E, T));
                list.add(new Edge(E, S, T));
            }

            // 웜홀
            for (int j = 0; j < W; j++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                list.add(new Edge(S, E, -T));
            }

            boolean result = false; // 음수사이클 없음
            for (int start = 1; start <= N ; start++) {

                if(bellmanford(N, M, start)){
                    result = true; // 음수사이클 있음
                    break;
                }
            }

            if(result){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }

    public static boolean bellmanford(int N, int M, int start){
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        boolean check = false;

        for (int i = 0; i <= N; i++) {
            check = false;

            for (Edge edge : list) {

                if(dist[edge.from] == Integer.MAX_VALUE){
                    continue;
                }

                if(dist[edge.to] > dist[edge.from] + edge.time){
                    dist[edge.to] = dist[edge.from] + edge.time;
                    check = true;

                    if(i == N){
                        return true;
                    }
                }
            }

            if(!check){
                break;
            }
        }

        return false; // 음수 사이클 없음

    }
}
