import java.util.*;

class Solution{
    public int[] solution(int[] progresses, int[] speeds){
        Queue<Integer> answer = new ArrayDeque<>(); // 😻 answer을 큐로?
        int n = progresses.length;

        // 각 작업의 배포 가능일 계산
        int[] daysLeft = new int[n];
        for(int i = 0; i < n; i++){
            daysLeft[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]); // 😻 반올림이 있었군
        }

        // 배포될 작업의 수 카운트
        int count = 0;
        int maxDay = daysLeft[0]; // 현재 배포될 작업 중 가장 늦게 배포될 작업의 가능일

        for(int i = 0; i < n; i++){
                if(daysLeft[i] <= maxDay){ // 배포 가능일이 가장 늦은 배포일보다 빠르면
                        count++;
                }else{ // 배포 가능일이 가장 늦은 배포일보다 느리면, 새로 세팅
                        answer.add(count);
                        count = 1;
                        maxDay = daysLeft[i];
                }
        }

        // 반복문을 나오기 바로 직전에 count한 값은 answer에 add()로 추가하지 않기 때문에 반복문 바깥에서 추가해줘야 한다.
        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}