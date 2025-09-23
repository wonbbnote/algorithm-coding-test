
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            }else{
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            int num = arr[i];
            int count = map.get(num);

            while(!stack.isEmpty() && count > map.get(arr[stack.peek()])){
                res[stack.pop()] = num;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            res[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int n: res){
            sb.append(n);
            sb.append(' ');
        }
        System.out.println(sb);
    }
}
