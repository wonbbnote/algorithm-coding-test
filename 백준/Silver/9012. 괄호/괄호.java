
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();

            ArrayDeque<Character> stack = new ArrayDeque<>();
            boolean res = true;
            for (char c: arr){
                if(c == '('){
                    stack.push(')');
                }else if(!stack.isEmpty() && c == ')'){
                    stack.pop();
                }else{
                    res = false;
                    break;
                }
            }

            if(!stack.isEmpty()){
                res = false;
            }
            
            if(res){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
