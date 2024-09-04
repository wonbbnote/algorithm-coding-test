import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        Queue<String> queue1 = new ArrayDeque<>();
        Queue<String> queue2 = new ArrayDeque<>();
        for(int i = 0; i < cards1.length; i++){
            queue1.add(cards1[i]);
        }
        for(int i = 0; i < cards2.length; i++){
            queue2.add(cards2[i]);
        }
        
        for(int i = 0; i < goal.length; i++){
            if(!queue1.isEmpty() && queue1.peek().equals(goal[i])){
                queue1.poll();
            }else if(!queue2.isEmpty() && queue2.peek().equals(goal[i])){
                queue2.poll();
            }else{
                answer = "No";
                break;
            }
        }
        
        
        return answer;
    }
}