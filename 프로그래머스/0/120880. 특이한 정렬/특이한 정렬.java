import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        
        Integer[] numlistWrapper = Arrays.stream(numlist).boxed().toArray(Integer[]::new);
        
        Arrays.sort(numlistWrapper, (o1, o2) -> Math.abs(n - o1) == Math.abs(n - o2) ? o2 - o1 : Math.abs(n - o1) - Math.abs(n - o2));
        
        int[] answer = Arrays.stream(numlistWrapper).mapToInt(Integer::intValue).toArray();


        

        
        return answer;
    }
}