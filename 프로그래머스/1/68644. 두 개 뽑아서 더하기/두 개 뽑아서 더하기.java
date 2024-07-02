import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        ArrayList<Integer> answers = new ArrayList<>();
        choice_2(numbers, 0, new ArrayList<>(), answers);
        Collections.sort(answers);
        answer = answers.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
    
    public void choice_2(int[] numbers, int start, ArrayList<Integer> choice, ArrayList<Integer> answer){
        
        if(choice.size() == 2){
            Integer sum = choice.get(0) + choice.get(1);
            if(!answer.contains(sum)){
                answer.add(sum);
            }
            return;
        }
        
        for(int i = start; i < numbers.length; i++){
            choice.add(numbers[i]);
            choice_2(numbers, i+1, choice, answer);
            choice.remove(choice.size() - 1);
        }
    }
}