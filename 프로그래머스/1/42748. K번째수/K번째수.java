import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++){
            int num = commands[i][1] - commands[i][0] + 1;
            int start = commands[i][0] - 1;
            
            int[] intArr = new int[num];
            for(int j = 0; j < num; j++){
                intArr[j] = array[start];
                start++;
            }
            
            Arrays.sort(intArr);
            answer[i] = intArr[commands[i][2] - 1];
        }
        
        return answer;
    }
}