import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(arr[0]);

        for (int i = 1; i < N; i++) {
            int num = arr[i];
            if(num > sub.get(sub.size()-1)){
                sub.add(num);
            }else{
                int j = binarySearch(sub, num);
                sub.set(j, num);
            }
        }
        System.out.println(sub.size());
    }

    private static int binarySearch(ArrayList<Integer> sub, int num){
        int left = 0;
        int right = sub.size() - 1;
        int mid;

        while(left < right){
            mid = (left + right) / 2;
            if(sub.get(mid) == num){
                return mid;
            }
            if(sub.get(mid) < num){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
