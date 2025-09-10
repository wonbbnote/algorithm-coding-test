
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        int num = 1;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String numStr = num + "";
            map.put(numStr, s);
            map.put(s, numStr);
            num++;
        }

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            String result = map.get(s);
            System.out.println(result);
        }

    }
}
