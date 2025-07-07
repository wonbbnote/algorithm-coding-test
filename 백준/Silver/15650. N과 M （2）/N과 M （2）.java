
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[] arr = new int[N];
        for (int i = 1; i <= N; i++) {
            arr[i - 1] = i;
        }
        backtracking(0, arr, M, new ArrayList<>());

    }

    public static void backtracking(int start, int[] arr, int m, List<Integer> caseList){

        if(caseList.size() == m){
            for (int i = 0; i < m ; i++) {
                System.out.print(caseList.get(i) + " ");
            }
            System.out.println();
            return;
        }
        
        for (int i = start; i < arr.length; i++) {
            caseList.add(arr[i]);
            backtracking(i + 1, arr, m, caseList);
            caseList.remove(caseList.size() - 1);
        }
    }
}
