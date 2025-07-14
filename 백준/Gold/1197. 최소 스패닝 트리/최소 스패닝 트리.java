
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    static class Node{
        int n1, n2, w;
        Node(int n1, int n2, int w){
            this.n1 = n1;
            this.n2 = n2;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        for (int i = 1; i <= V ; i++) {
            parent[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Node(n1, n2, w));
        }

        int total = 0;
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            if(!isSame(curr.n1, curr.n2)){
                total += curr.w;
                union(curr.n1, curr.n2);
            }
        }

        System.out.println(total);

    }

    public static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            parent[x] = y;
        }
    }

    public static boolean isSame(int x, int y){
        return find(x) == find(y);
    }
}
