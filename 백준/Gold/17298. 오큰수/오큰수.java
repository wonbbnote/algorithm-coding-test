
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[N];

        for (int i = 0; i < N; i++) {

            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                res[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            res[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();

        for (int n : res){
            sb.append(n);
            sb.append(' ');
        }

        System.out.println(sb);
    }
}
