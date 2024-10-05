import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; 
        
        int[] grade = new int[3];
        for(int i = 0; i < answers.length; i++){
            int ans = answers[i];
            if(first[i % first.length] == ans) grade[0]++;
            if(second[i % second.length] == ans) grade[1]++;
            if(third[i % third.length] == ans) grade[2]++;
        }
        
        int max = Arrays.stream(grade).max().getAsInt();
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < grade.length; i++){
            if(grade[i] == max){
                answer.add(i + 1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}