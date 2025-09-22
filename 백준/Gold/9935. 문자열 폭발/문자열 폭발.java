import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String bombString = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            sb.append(c);

            if(sb.length() >= bombString.length()) {
                boolean flag = true;
                for (int j = 0; j < bombString.length(); j++) {
                    if (bombString.charAt(j) != sb.charAt(sb.length() - bombString.length() + j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    sb.setLength(sb.length() - bombString.length());
                }
            }
        }

        if(sb.length() == 0){
            System.out.println("FRULA");
        }else{
            System.out.println(sb);
        }

    }
}
