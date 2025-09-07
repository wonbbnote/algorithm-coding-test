import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int[] cards = new int[N];
        for (int i = 0; i < N ; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(!map.containsKey(n)){
                map.put(n, 1);
            }else{
                map.put(n, map.get(n) + 1);
            }
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[M];
        for (int i = 0; i < M ; i++) {
            int n = Integer.parseInt(st.nextToken());

            nums[i] = map.getOrDefault(n, 0);
        }

        for(int n : nums){
            System.out.print(n + " ");
        }
    }
}
