
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        tracking(N, M, new ArrayList<>());
    }

    public static void tracking(int n, int m, List<Integer> caseList){
        if(caseList.size() == m){
            for (int num: caseList){
                System.out.print(num + " ");
            }
            System.out.println();
        }

        for(int i = 1; i <= n; i++){
            if(!caseList.contains(i)){
                caseList.add(i);
                tracking(n, m, caseList);
                caseList.remove(caseList.size()-1);
            }
        }
    }
}
