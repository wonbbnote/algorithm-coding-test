import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int[] result;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();

        result = new int[N+1];
        for (int i = 0; i <= N; i++) {
            result[i] = i;
        }

        for(int i = 0; i < M; i++){
            int S = scan.nextInt();
            int A = scan.nextInt();
            int B = scan.nextInt();

            if(S == 0){
                union(A, B);

            }else{
                if(checkSame(A, B)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }

    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        return a == b;
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b){
            result[b] = a;
        }
    }

    private static int find(int a) {
        if(a == result[a]){
            return a;
        }else{
            return result[a] = find(result[a]);
        }
    }




}
