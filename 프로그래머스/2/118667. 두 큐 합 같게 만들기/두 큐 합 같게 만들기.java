// 1. Queue를 이용
import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        
        // 1. 각 정수배열의 합 구하기
        // "언어에 따라 합 계산 과정 중 산술 오버플로우 발생 가능성이 있으므로 long type 고려"
        long q1_sum = Arrays.stream(queue1).sum(); 
        long q2_sum = Arrays.stream(queue2).sum();
        
        // 2. int[] to Queue list 
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i = 0 ; i < queue1.length; i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        // 3. 정수 배열 합이 같을 때까지 반복문 돌리기
        // 큐 원소의 합이 더 큰 쪽의 원소를 빼고 작은 큐에 삽입한다
        // 단, 반복 횟수가 4 * queue1.length 이상일 때는 -1로 리턴
        int num = 0;
        while(q1_sum != q2_sum){
            if(num >= 4 * queue1.length){
                num = -1;
                break;
                
            }else if(q1_sum > q2_sum){
                int d_num = q1.remove();
                q2.add(d_num);
                q1_sum -= d_num;
                q2_sum += d_num;
                num++;
                
            }else if(q1_sum < q2_sum){
                int d_num = q2.remove();
                q1.add(d_num);
                q2_sum -= d_num;
                q1_sum += d_num;
                num++;
            } 
        }
        answer = num;
        
        return answer;
    }
}