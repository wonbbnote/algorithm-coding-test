
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

        Set<String> set1 = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set1.add(br.readLine());
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if(set1.contains(s)){
                list.add(s);
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(String s : list){
            System.out.println(s);
        }

    }
}
