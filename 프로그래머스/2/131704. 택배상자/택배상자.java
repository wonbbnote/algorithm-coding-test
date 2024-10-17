import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        int firstContainer = 1;
        for(int i = 0; i < order.length; i++){
            int orderNum = order[i];
            // System.out.println("orderNum: "+orderNum);
            // System.out.println("firstContainer: "+firstContainer);
            // System.out.println("stack: "+stack);
            
            if(orderNum != firstContainer){
                
                // 기존 컨테이너에 있는 상자의 번호가 실어야 하는 상자의 번호보다 작을 때 스택에 넣기
                if(firstContainer < orderNum){
                    
                    while(firstContainer < orderNum){
                        stack.push(firstContainer);
                        firstContainer++;
                    }
                    firstContainer++;
                    answer++;
                
                // 기존 컨테이너의 상자의 번호가 더 클 때, 스택에서 찾기
                }else if(!stack.isEmpty() && stack.peek() == orderNum){
                    stack.pop();
                    answer++;
                
                // 그 외의 경우 break;
                }else{
                    break;
                }
            
            // 상자 번호가 같을때는 싣기! 기존 컨테이너 상자 번호++
            }else{
                firstContainer++;
                answer++;
            }
            
            // 기존 컨테이너에 남아있는 상자 번호가 상자 개수보다 많고, 스택이 비어있으면
            // if(firstContainer > order.length && stack.isEmpty()){
            //     break;
            // }
            
        }
        
        return answer;
    }
}