
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int num = 0;
        
        String binaryString = Integer.toBinaryString(X);
        for (int i = 0; i < binaryString.length(); i++) {
            char c = binaryString.charAt(i);
            if(c == '1'){
                num++;
            }
        }
        System.out.println(num);
    }
}
