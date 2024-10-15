import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        
        for (String operation: operations) {
            char operator = operation.charAt(0);
            int num = Integer.parseInt(operation.substring(2));
            
            // 숫자 삽입
            if (operator == 'I') {
                max.add(num);
                min.add(num);
            }
            // 최댓값 삭제
            else if (max.size() > 0 && operator == 'D' && num == 1) {
                min.remove(max.poll());
            }
            // 최솟값 삭제
            else if (max.size() > 0 && operator == 'D') {
                max.remove(min.poll());
            }
        }
        
        // 큐가 비어있지 않는 경우
        if (max.size() > 0) {
            answer[0] = max.poll();
            answer[1] = min.poll();
        }
        
        return answer;
    }
}