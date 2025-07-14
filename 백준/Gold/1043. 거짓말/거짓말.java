import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, Integer> knowTruthMap;
    static int[] group;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람수
        int M = Integer.parseInt(st.nextToken()); // 파티수

        group = new int[N+1];
        for (int i = 1; i <= N; i++) {
            group[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int knowTruthNum = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수

        Set<Integer> set = new HashSet<>();
        int knowGroupNum = -1;
        for (int i = 0; i < knowTruthNum; i++) {
            int p = Integer.parseInt(st.nextToken());
            set.add(p);
            if(knowGroupNum == -1){
                knowGroupNum = p;
            }
            union(p, knowGroupNum);
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> party = new ArrayList<>();
            int partyOne = Integer.parseInt(st.nextToken()); // 파티마다 오는 사람의 수
            int base = -1;
            for (int j = 0; j < partyOne; j++) {
                int p = Integer.parseInt(st.nextToken());
                party.add(p);
                if(base == -1) base = p;
                else union(base, p);
            }
            parties.add(party);
        }

        int res = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                for (int t : set) {
                    if (find(person) == find(t)) {
                        canLie = false;
                        break;
                    }
                }
                if (!canLie) break;
            }
            if (canLie) res++;
        }
        System.out.println(res);
    }

    public static int find(int x){
        if(group[x] != x){
            group[x] = find(group[x]);
        }
        return group[x];
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            group[x] = y;
        }
    }
}
