import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

        Set<String> set = new HashSet<>();

        tracking(M, arr, new ArrayList<>(), set);

    }

    public static void tracking(int m, int[] arr, List<Integer> caseList, Set<String> set) {

        if(caseList.size() == m){
            StringBuilder sb = new StringBuilder();
            for (int n : caseList){
                sb.append(arr[n] + " ");
            }
            String s = sb.toString();

            if(!set.contains(s)){
                System.out.println(s);
                set.add(s);
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(!caseList.contains(i)){
                caseList.add(i);
                tracking(m, arr, caseList, set);
                caseList.remove(caseList.size() - 1);
            }
        }
    }
}
