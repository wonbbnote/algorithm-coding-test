import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] dollLoca = new int[board[0].length];
        A:for(int j = 0; j < board[0].length; j++){
            for(int i = 0; i < board.length; i++){
                if(board[i][j] != 0){
                    dollLoca[j] = i;
                    continue A;
                }
            }
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for(int move: moves){
            
            if(dollLoca[move-1] == -1){
                continue;
            }
            
            int doll = board[dollLoca[move-1]][move-1];
            
            if(!stack.isEmpty() && doll == stack.peek()){
                stack.pop();
                answer++;
            }else{
                stack.push(doll);
            }
            
            if(dollLoca[move-1] < board.length-1){
                dollLoca[move-1]++;
            }else{
                dollLoca[move-1] = -1;
            }
            
            
        }
        
        return answer*2;
    }
}