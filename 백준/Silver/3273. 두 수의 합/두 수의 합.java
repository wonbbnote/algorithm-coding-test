
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine());

        int count = 0;

        int a = 0;
        int b = n - 1;
        while (a < b) {
            if(arr[a] + arr[b] > x){
                b--;
            }else if(arr[a] + arr[b] < x){
                a++;
            }else{
                a++;
                count++;
            }
        }

        System.out.println(count);

    }
}
