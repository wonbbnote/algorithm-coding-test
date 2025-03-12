
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 박스를 채우는데 필요한 큐브의 최소 개수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 박스 크기
        int length = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        // 큐브의 종류
        int N = Integer.parseInt(br.readLine());
        int[][] block = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            block[i][0] = num;
            block[i][1] = count;
        }
        Arrays.sort(block, (a, b) -> b[0] - a[0]);

        long volume = (long) length * width * height;
        long totalCount = 0;
        long usedVolume = 0;

        for (int i = 0; i < N; i++) {
            long size = (1 << block[i][0]);
            int count = block[i][1];

            if(volume <= usedVolume){
                break;
            }
            long maxCount = (length / size) * (width / size) * (height / size);
            maxCount -= usedVolume / (size * size * size);
            long useCount = Math.min(count, maxCount);

            usedVolume += useCount * (size * size * size);
            totalCount += useCount;
        }

        if(usedVolume == volume){
            System.out.println(totalCount);
        }else{
            System.out.println(-1);
        }

    }
}
