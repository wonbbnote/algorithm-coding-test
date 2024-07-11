import java.util.*;
class Solution {
    public long solution(String numbers) {
        long answer = 0;
        String[] numberArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0; i < numberArr.length; i++){
            numbers = numbers.replace(numberArr[i], String.valueOf(i));
        }
        
        answer = Long.parseLong(numbers);
        return answer;
    }
}