import java.util.*;
class Solution {
    public int longestValidParentheses(String s) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        boolean[] boolArr = new boolean[s.length()];
        Arrays.fill(boolArr, false);

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else if(s.charAt(i) == ')' && !stack.isEmpty()){
                int popped = stack.pop();
                boolArr[popped] = true;
                boolArr[i] = true;

            }
        }

        int num = 0;
        for(int i = 0; i < boolArr.length; i++){
            if(i == boolArr.length - 1){
                if(boolArr[i]){
                    num++;
                }
                pq.add(num);

            }else if(boolArr[i] && boolArr[i+1]){
                num++;
            }else if(boolArr[i] && !boolArr[i+1]){
                num++;
                pq.add(num);
                num = 0;
            }
            // System.out.println("startIdx: "+startIdx + ", endIdx: "+endIdx);
            System.out.println("num: "+num);
            System.out.println("pq: "+pq);
        }
        
        if(!pq.isEmpty()){
            answer = pq.remove();
        }

        return answer;
    }
}