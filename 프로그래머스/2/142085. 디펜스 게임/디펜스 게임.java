import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        
        // 무적권은 적이 많은 라운드에서 사용할 수 있다.
        // 아니면 적의 수만큼 병사를 소모해야한다
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < enemy.length; i++){
            n -= enemy[i];
            pq.add(enemy[i]);
            
            if(n < 0){
                if(k > 0 && !pq.isEmpty()){
                    int max = pq.poll();
                    n += max;
                    k--;
                }else{
                    answer = i;
                    break;
                }
                
            }
        }
        
        return answer;
    }
}