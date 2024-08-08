import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int index = 0;
        
        for(int i = 0; i < lost.length; i++){
            // 먼저 여벌로 가져온 학생이 도난당한 경우가 있으면 그냥 자기꺼 쓰면 됨
            for(int j = 0; j < reserve.length; j++){
                if(reserve[j] == lost[i]){
                    answer++;
                    reserve[j] = -1;
                    lost[i] = -1;
                    break;
                }
            }
        }
        
        for(int i = 0; i < lost.length; i++){
            if(lost[i] == -1){
                continue;
                
            }else{
                
                int before = lost[i] - 1;
                int after = lost[i] + 1;
            
                // 그외에 도난 당한 학생이 빌릴 수 있는 것이 있는지 확인
                for(int j = 0; j < reserve.length; j++){
                    if(reserve[j] == -1){
                        continue;
                    }
                    if(reserve[j] == before || reserve[j] == after){
                        answer++;
                        reserve[j] = -1;
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(reserve));
        
        
        
        return answer;
    }
}