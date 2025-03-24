

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 로프의 개수
        int[] ropes = new int[N];
        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);

        int maxWeight = 0;
        for (int i = 1; i <= N; i++) {
            maxWeight = Math.max(maxWeight, ropes[N-i] * i);
        }

        System.out.println(maxWeight);
    }
}
