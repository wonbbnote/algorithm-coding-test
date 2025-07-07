
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int N = Integer.parseInt(s1[0]);
        int M = Integer.parseInt(s1[1]);

        String[] s2 = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s2[i]);
        }
        Arrays.sort(arr);

        tracking(M, arr, new ArrayList<>());

    }

    public static void tracking(int m, int[] arr, List<Integer> caseList){

        if(caseList.size() == m){
            for(int n: caseList){
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(!caseList.contains(arr[i])){
                caseList.add(arr[i]);
                tracking(m, arr, caseList);
                caseList.remove(caseList.size() - 1);
            }
        }
    }
}
