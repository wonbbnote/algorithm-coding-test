import java.util.*;

class Solution {
    public int solution(int n, int k) {
        
        String kString = Integer.toString(n, k);
        String[] arr = kString.split("0");
        int answer = 0;

        // 분리된 문자열 배열을 순회
        for (String s : arr) {
            if (s.equals("")) {
                continue;
            }

            // 문자열을 long 타입 숫자로 변환합니다.
            long num = Long.parseLong(s);

            // 변환된 숫자가 소수인지 확인
            if (isPrime(num)) {
                answer++; 
            }
        }

        return answer;
    }
    
    // 소수인지 여부를 판단하는 메서드
    private static boolean isPrime(long num) {

        if (num <= 1) {
            return false;
        }
        
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
