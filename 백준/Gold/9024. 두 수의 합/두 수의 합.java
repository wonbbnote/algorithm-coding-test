
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            String[] inputArr = br.readLine().split(" ");
            int[] arr = new int[inputArr.length];
            for (int j = 0; j < inputArr.length; j++) {
                arr[j] = Integer.parseInt(inputArr[j]);
            }

            Arrays.sort(arr);

            int closestDifference = Integer.MAX_VALUE;
            int count = 0;
            int left = 0, right = n-1;

            while(left < right){
                int sum = arr[left] + arr[right];
                int difference = Math.abs(sum - K);

                if(difference < closestDifference){
                    closestDifference = difference;
                    count = 1;
                }else if(difference == closestDifference){
                    count++;
                }

                if(sum < K){
                    left++;
                }else{
                    right--;
                }
            }
            System.out.println(count);
        }
    }
}
