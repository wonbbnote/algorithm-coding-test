
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String phoneNum = br.readLine();
                arr[j] = phoneNum;
                map.put(phoneNum, j);
            }

            boolean confirm = true;
            for (int k = 0; k < n; k++){
                for (int j = 0; j < arr[k].length(); j++) {
                    if(map.containsKey(arr[k].substring(0, j))){
                        confirm = false;
                    }
                }
            }

            if(confirm){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }
}
