import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 센서의 개수
        int K = Integer.parseInt(br.readLine()); // 집중국의 개수

        int[] sensors = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(minSensorRange(N, K, sensors));
    }

    private static int minSensorRange(int n, int k, int[] sensors) {
        Arrays.sort(sensors);
        ArrayList<Integer> distances = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            distances.add(sensors[i] - sensors[i-1]);
        }
        Collections.sort(distances);

        int result = sensors[n-1] - sensors[0];
        for (int i = 0; i < Math.min(k-1, n-1); i++) {
            result -= distances.get(distances.size() - i - 1);
        }

        return Math.max(0, result);

    }
}
