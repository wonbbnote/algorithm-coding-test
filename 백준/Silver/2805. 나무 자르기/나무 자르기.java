
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int max = 0;
        int[] arr = new int[N];
        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        long left = 1;
        long right = max;

        while(left < right){
            long mid = (left + right) / 2; // height

            long trees = 0;
            for(int tree: arr){
                if(tree > mid){
                    trees += (tree - mid);
                }
            }

            if(trees < M){
                right = mid;
            }else{
                left = mid + 1;
            }

        }

        System.out.println(left - 1);

    }
}
