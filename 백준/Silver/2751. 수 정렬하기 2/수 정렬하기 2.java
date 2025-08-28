
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N ; i++) {
            int n = Integer.parseInt(br.readLine());
            set.add(n);
        }

        List<Integer> list = new ArrayList<>();
        for(int n: set){
            list.add(n);
        }

        Collections.sort(list);

        for(int n: list){
            System.out.println(n);
        }

    }
}
