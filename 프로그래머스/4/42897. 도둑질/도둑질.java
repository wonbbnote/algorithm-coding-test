import java.util.*;
class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        // 첫집을 터는 경우
        int[] dpFirst = new int[money.length];
        dpFirst[0] = money[0];
        dpFirst[1] = money[0];
        
        int[] dpSecond = new int[money.length];
        dpSecond[0] = 0;
        dpSecond[1] = money[1];
        
        // 점화식
        for(int i = 2; i < money.length; i++){
            dpFirst[i] = Math.max(dpFirst[i-2] + money[i], dpFirst[i-1]);
            dpSecond[i] = Math.max(dpSecond[i-2] + money[i], dpSecond[i-1]);
        }
        // System.out.println(Arrays.toString(dpFirst));
        // System.out.println(Arrays.toString(dpSecond));
        
        return Math.max(dpFirst[money.length - 2], dpSecond[money.length - 1]);
    }
}