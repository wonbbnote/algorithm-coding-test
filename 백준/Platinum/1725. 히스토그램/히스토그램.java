import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] h = new int[N];
        for (int i = 0; i < N; i++) h[i] = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        long maxArea = 0;

        for (int i = 0; i <= N; i++) {
            int cur = (i == N) ? 0 : h[i];
            while (!stack.isEmpty() && h[stack.peek()] >= cur) {
                int top = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                long area = (long) h[top] * width;
                if (area > maxArea) maxArea = area;
            }
            stack.push(i);
        }
        System.out.println(maxArea);
    }
}
