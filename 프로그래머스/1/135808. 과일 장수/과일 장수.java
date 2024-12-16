import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        int box = score.length / m;
        Arrays.sort(score);
        
        int sum = 0;
        int start = score.length - box*m;
        
        for(int i = 0; i < box;i++){
            sum += score[start];
            start += m;
        }
        answer = sum * m;

        return answer;
    }
}