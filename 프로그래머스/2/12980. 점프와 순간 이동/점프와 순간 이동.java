import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        // K 칸을 앞으로 점프 -> K 건전지 사용량
        // (현재까지 온 거리) x 2 에 해당하는 위치로 순간이동
        // 점프를 최소한으로 하여 N만큼 떨어져 있는 장소로 가기
        // 사용해야 하는 건전지 사용량의 최솟값을 return
    
        
        return Integer.toBinaryString(n).replace("0", "").length();
    }
}