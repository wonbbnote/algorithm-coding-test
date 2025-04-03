import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int result = countLuckyPermutations(input);
        System.out.println(result);  // 결과 출력
    }

    public static int countLuckyPermutations(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);  // 입력 문자열 정렬
        boolean[] used = new boolean[chars.length];
        return generatePermutations(chars, "", used, '\0');
    }

    public static int generatePermutations(char[] chars, String current, boolean[] used, char lastChar) {
        if (current.length() == chars.length) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            // 인접한 문자열이 다른 행운 문자열을 구성해야 합니다. 이전 문자와 동일하면 비교할 필요가 없습니다.
            if (used[i] || (i > 0 && chars[i] == chars[i - 1] && !used[i - 1])) {
                continue;
            }
            // 추가될 문자와 생성된 순열의 마지막 글자가 같다면 의미없겠죠?
            if (current.length() > 0 && chars[i] == lastChar) {
                continue;
            }

            used[i] = true;
            // 현재 문자를 추가하여 다시 순열을 생성
            count += generatePermutations(chars, current + chars[i], used, chars[i]);
            used[i] = false;
        }

        return count;
    }
}