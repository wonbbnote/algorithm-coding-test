import java.util.*;
class Solution {
    static int[] answer;
    public int[] solution(int n) {

        
        int last = n * (n+1) / 2;
        answer = new int[last];
        
        first(1, 0, n, 1);
        
        return answer;
    }
    
    private static void first(int startNum, int startIdx, int n, int nth){
        int loopNum = (n - 1) - 3*(nth - 1);
        if(loopNum == 0){
            answer[startIdx] = startNum;
            return;
        }
        
        int added = 2 * (nth - 1) + 1;
        for(int i = 0; i < loopNum; i++){
            answer[startIdx] = startNum++;
            startIdx += added++;
        }
        second(startNum, startIdx, n, nth);
    }
    
    private static void second(int startNum, int startIdx, int n, int nth){
        int loopNum = (n - 1) - 3*(nth - 1);
        for(int i = 0; i < loopNum; i++){
            answer[startIdx++] = startNum++;
        }
        third(startNum, startIdx, n, nth);
    }
    
    private static void third(int startNum, int startIdx, int n, int nth){
        int loopNum = (n - 1) - 3*(nth - 1);
        int minus = n - (nth - 1);
        for(int i = 0; i < loopNum; i++){
            answer[startIdx] = startNum++;
            if(i < loopNum - 1){
                startIdx -= minus--;
            }
            
        }
        // System.out.println("last startIdx: "+ startIdx + ", last startNum: "+startNum);
        // System.out.println("answer: "+ Arrays.toString(answer));
        
        if(loopNum >= 3){
            first(startNum, startIdx + 2 * nth, n, nth+1);
        }else{
            return;
        }
        
    }
    
    
}