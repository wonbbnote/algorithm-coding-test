
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] sour = new int[N];
        int[] bitter = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        int minDiff = Integer.MAX_VALUE;
        
        for (int i = 1; i < (1 << N); i++) { // 재료의 가짓 수
            int sourTaste = 1;
            int bitterTaste = 0;
            for (int j = 0; j < N; j++) {
                if((i & (1 << j)) != 0){
                    sourTaste *= sour[j];
                    bitterTaste += bitter[j];
                }
            }
            minDiff = Math.min(minDiff, Math.abs(sourTaste - bitterTaste));
        }
        System.out.println(minDiff);
    }
}
